package com.opower.couchdb_talk.model;

import java.util.List;

/**
 * @author tomvaughan
 */
public class Artist extends AbstractRandomCouchDbObject {
    private long id;
    private String name;
    private String url;
    private String image;
    private String mbgid;
    private Location location;
    private List<Album> albums;

    public Artist() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMbgid() {
        return mbgid;
    }

    public void setMbgid(String mbgid) {
        this.mbgid = mbgid;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
