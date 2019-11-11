package com.yehoudit.geoLocation.model;

import javax.persistence.*;

@Entity
public class Searches {

    public Searches() {
    }

    public Searches(double km, int numberHits, LocationsFromApi source, LocationsFromApi dest) {
        this.km = km;
        this.numberHits = numberHits;
        this.source = source;
        this.dest = dest;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private double km;

    @Column
    private int numberHits;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne
    private LocationsFromApi source;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne
    private LocationsFromApi dest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public int getNumberHits() {
        return numberHits;
    }

    public void setNumberHits(int numberHits) {
        this.numberHits = numberHits;
    }

    public LocationsFromApi getSource() {
        return source;
    }

    public void setSource(LocationsFromApi source) {
        this.source = source;
    }

    public LocationsFromApi getDest() {
        return dest;
    }

    public void setDest(LocationsFromApi dest) {
        this.dest = dest;
    }
}
