package com.opower.couchdb_talk.model;

import java.util.List;

/**
 * @author tomvaughan
 */
public class JamendoData {

    private List<Artist> artists;
    private long epoch;
    private String documentation;
    private String type;
    
    
    public JamendoData() {
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public long getEpoch() {
        return epoch;
    }

    public void setEpoch(long epoch) {
        this.epoch = epoch;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }    
}
