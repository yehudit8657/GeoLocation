package com.yehoudit.geoLocation.Dao;

import com.yehoudit.geoLocation.model.LocationsFromApi;
import com.yehoudit.geoLocation.model.Searches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchesDao extends JpaRepository<Searches,Integer> {
    Searches findBySourceAndDest(LocationsFromApi source, LocationsFromApi dest);
}
