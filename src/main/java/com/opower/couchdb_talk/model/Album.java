package com.opower.couchdb_talk.model;

import java.util.List;

/**
 *
 * @author tomvaughan
 */
public class Album {
    private long id;
    private String name;
    private String url;
    private int id3genre;
    private String mbgid;
    private String license_artwork;
    private String releasedate;
    private String filename;
    private List<Track> tracks;

    public Album() {
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

    public int getId3genre() {
        return id3genre;
    }

    public void setId3genre(int id3genre) {
        this.id3genre = id3genre;
    }

    public String getMbgid() {
        return mbgid;
    }

    public void setMbgid(String mbgid) {
        this.mbgid = mbgid;
    }

    public String getLicense_artwork() {
        return license_artwork;
    }

    public void setLicense_artwork(String license_artwork) {
        this.license_artwork = license_artwork;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
