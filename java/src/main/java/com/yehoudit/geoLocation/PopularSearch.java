package com.yehoudit.geoLocation;

import com.yehoudit.geoLocation.Dao.SearchesDao;
import com.yehoudit.geoLocation.model.Searches;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PopularSearch {
    @Autowired
    private SearchesDao searchesDao;

    private String source;
    private String dest;
    private int hits;

    public PopularSearch() {
    }

    public PopularSearch(String source, String dest, int hits) {
        this.source = source;
        this.dest = dest;
        this.hits = hits;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

}
