package com.opower.couchdb_talk.model;

/**
 * <p>A POJO that has both CouchDb _id and _rev fields, as well as a "random" double value</p>
 * @author tomvaughan
 */
public class AbstractRandomCouchDbObject extends AbstractCouchDbObject {
    private double random;

    public double getRandom() {
        return random;
    }

    public void setRandom(double random) {
        this.random = random;
    }
}
