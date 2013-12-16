package com.opower.couchdb_talk.model;

/**
 * @author tomvaughan
 */
public class Location extends AbstractCouchDbObject {
    private String country;
    private String state;
    private String city;
    private String latitude;  // String because we sometimes encouter "None" in the XML and I don't feel like writing 
    private String longitude; // a custom Castor field handler

    public Location() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
