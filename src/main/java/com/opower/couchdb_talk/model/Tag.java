package com.opower.couchdb_talk.model;

/**
 *
 * @author tomvaughan
 */
public class Tag extends AbstractRandomCouchDbObject {
    private String idstr;
    private float weight;

    public Tag() {
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
