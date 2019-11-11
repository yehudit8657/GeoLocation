package com.yehoudit.geoLocation.Dao;


import com.yehoudit.geoLocation.model.LocationsGiven;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationsGivenDao extends JpaRepository<LocationsGiven,Integer> {
    LocationsGiven findByAddressGiven(String addressGiven);
}
