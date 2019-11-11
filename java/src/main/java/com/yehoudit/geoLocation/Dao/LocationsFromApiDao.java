package com.yehoudit.geoLocation.Dao;

import com.yehoudit.geoLocation.model.LocationsFromApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationsFromApiDao extends JpaRepository<LocationsFromApi,Integer> {
    LocationsFromApi findByAddressFromApi(String addressFromApi);
}
