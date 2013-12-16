package com.opower.couchdb_talk.model;

import java.util.List;

/**
 * A track on an album
 * @author tomvaughan
 */
public class Track extends AbstractRandomCouchDbObject {
    private long id;
    private String name;
    private float duration;
    private String filename;
    private String mbgid; // Musicbrainz ID (may be blank)
    private int numalbum;
    private int id3genre;
    private String license;
    private List<Tag> tags;

    public Track() {
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

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMbgid() {
        return mbgid;
    }

    public void setMbgid(String mbgid) {
        this.mbgid = mbgid;
    }

    public int getNumalbum() {
        return numalbum;
    }

    public void setNumalbum(int numalbum) {
        this.numalbum = numalbum;
    }

    public int getId3genre() {
        return id3genre;
    }

    public void setId3genre(int id3genre) {
        this.id3genre = id3genre;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
