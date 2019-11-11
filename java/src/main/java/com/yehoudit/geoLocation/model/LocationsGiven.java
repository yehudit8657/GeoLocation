package com.yehoudit.geoLocation.model;

import javax.persistence.*;

@Entity
public class LocationsGiven {

    public LocationsGiven(){
    }

    public LocationsGiven(String addressGiven) {
        this.addressGiven = addressGiven;
    }

    public LocationsGiven(String addressGiven, LocationsFromApi idLocationFromApi) {
        this.addressGiven = addressGiven;
        this.locationsFromApi = idLocationFromApi;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String addressGiven;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne
    private LocationsFromApi locationsFromApi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressGiven() {
        return addressGiven;
    }

    public void setAddressGiven(String addressGiven) {
        this.addressGiven = addressGiven;
    }

    public LocationsFromApi getLocationsFromApi() {
        return locationsFromApi;
    }

    public void setLocationsFromApi(LocationsFromApi locationsFromApi) {
        this.locationsFromApi = locationsFromApi;
    }

}
