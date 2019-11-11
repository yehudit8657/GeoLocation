package com.yehoudit.geoLocation.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class LocationsFromApi {

    public LocationsFromApi() {
    }

    public LocationsFromApi(String addressFromApi) {
        this.addressFromApi = addressFromApi;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String addressFromApi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationsFromApi")
    private Collection<LocationsGiven> locationsGivenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "source")
    private Collection<Searches> searchesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dest")
    private Collection<Searches> searchesCollection1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressFromApi() {
        return addressFromApi;
    }

    public void setAddressFromApi(String addressFromApi) {
        this.addressFromApi = addressFromApi;
    }

    public Collection<LocationsGiven> getLocationsGivenCollection() {
        return locationsGivenCollection;
    }

    public void setLocationsGivenCollection(Collection<LocationsGiven> locationsGivenCollection) {
        this.locationsGivenCollection = locationsGivenCollection;
    }

    public Collection<Searches> getSearchesCollection() {
        return searchesCollection;
    }

    public void setSearchesCollection(Collection<Searches> searchesCollection) {
        this.searchesCollection = searchesCollection;
    }

    public Collection<Searches> getSearchesCollection1() {
        return searchesCollection1;
    }

    public void setSearchesCollection1(Collection<Searches> searchesCollection1) {
        this.searchesCollection1 = searchesCollection1;
    }
}
