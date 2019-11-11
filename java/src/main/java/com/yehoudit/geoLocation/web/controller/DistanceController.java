package com.yehoudit.geoLocation.web.controller;

import com.yehoudit.geoLocation.Dao.LocationsFromApiDao;
import com.yehoudit.geoLocation.Dao.LocationsGivenDao;
import com.yehoudit.geoLocation.Dao.SearchesDao;
import com.yehoudit.geoLocation.Exception.AddressNotFoundException;
import com.yehoudit.geoLocation.GoogleApi;
import com.yehoudit.geoLocation.PopularSearch;
import com.yehoudit.geoLocation.model.LocationsFromApi;
import com.yehoudit.geoLocation.model.LocationsGiven;
import com.yehoudit.geoLocation.model.Searches;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
public class DistanceController {

    @Autowired
    private LocationsGivenDao locationsGivenDao;
    @Autowired
    private LocationsFromApiDao locationsFromApiDao;
    @Autowired
    private SearchesDao searchesDao;

    JSONObject distanceDetails;
    List<Searches> lSearches;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/getDistance/{source}/{dest}",method= RequestMethod.GET)
    @ResponseBody
    public String getDistance(@PathVariable String source, @PathVariable String dest) throws Exception {
        GoogleApi g = new GoogleApi();

        //check in DB
        LocationsGiven source_given = locationsGivenDao.findByAddressGiven(source);
        LocationsGiven dest_given = locationsGivenDao.findByAddressGiven(dest);
        Searches search;

        //if this source and dest exists - check if they matches in searches
        if(source_given != null && dest_given != null) {
            search = searchesDao.findBySourceAndDest(source_given.getLocationsFromApi(), dest_given.getLocationsFromApi());
            //if they match- increase the hits
            if(search != null) {
                increaseHits(search.getId());
                return new Double(search.getKm()).toString();
            }
        }

        //if not found matches - go to api
        distanceDetails=g.callGoogleAPI(source, dest);

        String start_address = (String) distanceDetails.get("start_address");
        String end_address = (String) distanceDetails.get("end_address");
        String kmString = getKm();

        //check if this source and dest (from api) exists following different writing of this search
        LocationsFromApi source_from_api=locationsFromApiDao.findByAddressFromApi(start_address);
        LocationsFromApi dest_from_api=locationsFromApiDao.findByAddressFromApi(end_address);

        //if the source and dest (from api) exists - save the new source and dest that given and increase the hits if the search exists.
        if(source_from_api != null && dest_from_api != null) {
            if (source_given == null)
                saveLocationGiven(source, source_from_api);
            if (dest_given == null)
                saveLocationGiven(dest, dest_from_api);
            search = searchesDao.findBySourceAndDest(source_from_api, dest_from_api);
            if (search != null)
                increaseHits(search.getId());
            else
                search = saveSearches(Double.parseDouble(kmString), 1, source_from_api, dest_from_api);
        }
        //save in DB all the new data that not exists in DB
        else {
            if(source_from_api == null) {
                source_from_api = saveLocationFromApi((String) distanceDetails.get("start_address"));
                saveLocationGiven(source, source_from_api);
            }
            if(dest_from_api == null) {
                dest_from_api = saveLocationFromApi((String) distanceDetails.get("end_address"));
                saveLocationGiven(dest, dest_from_api);
            }
            search = saveSearches(Double.parseDouble(kmString),1,source_from_api,dest_from_api);
        }

        return new Double(search.getKm()).toString();
    }

    public String getKm() {
        JSONObject obj3 = (JSONObject) distanceDetails.get("distance");
        String kmText = (String) obj3.get("text");
        Pattern pattern = Pattern.compile("[0-9][0-9]*\\.?[0-9]");
        Matcher matcher = pattern.matcher(kmText);
        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new AddressNotFoundException("המקומות שהזנת אותרו אך התרחשה שגיאה");
        }
    }

    public void increaseHits(int id) {
        Searches s=searchesDao.findById(id).get();
        s.setNumberHits(s.getNumberHits()+1);
        searchesDao.save(s);
    }

    public LocationsFromApi saveLocationFromApi(String address) {
        LocationsFromApi l = new LocationsFromApi(address);
        locationsFromApiDao.save(l);
        return l;
    }

    public void saveLocationGiven(String address, LocationsFromApi lfa) {
        LocationsGiven l = new LocationsGiven(address, lfa);
        locationsGivenDao.save(l);
    }

    public Searches saveSearches(Double km, int nHits, LocationsFromApi l, LocationsFromApi l1) {
        Searches s=new Searches(km, nHits, l, l1);
        searchesDao.save(s);
        return s;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/getPopularSearch",method= RequestMethod.GET,produces = "application/json")
    public PopularSearch getPopularSearch() {
        PopularSearch p = new PopularSearch();
        lSearches = searchesDao.findAll().stream().sorted(Comparator.comparing(Searches::getNumberHits).reversed()).collect(Collectors.toList());
        Searches highHits = lSearches.get(0);
        p.setSource(highHits.getSource().getLocationsGivenCollection().stream().collect(Collectors.toList()).get(0).getAddressGiven());
        p.setDest(highHits.getDest().getLocationsGivenCollection().stream().collect(Collectors.toList()).get(0).getAddressGiven());
        p.setHits(highHits.getNumberHits());
        return p;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/getPopularSearchList",method= RequestMethod.GET,produces = "application/json")
    public List<PopularSearch> getPopularSearchList(){
        lSearches = searchesDao.findAll().stream().sorted(Comparator.comparing(Searches::getNumberHits).reversed()).limit(10).collect(Collectors.toList());
        List<PopularSearch> p = lSearches.stream()
                .map(search -> new PopularSearch(
                        search.getSource().getLocationsGivenCollection().stream().collect(Collectors.toList()).get(0).getAddressGiven(),
                        search.getDest().getLocationsGivenCollection().stream().collect(Collectors.toList()).get(0).getAddressGiven(),
                        search.getNumberHits()))
                .collect(Collectors.toList());
        return p;
    }
}