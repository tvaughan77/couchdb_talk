package com.opower.couchdb_talk.model;

/**
 * <p>Any object saved to couchDB gets an "_id" and "_rev" field on insert/save</p>
 * @author tomvaughan
 */
public class AbstractCouchDbObject {
    
    private String couchId; // the couchDB id is supposed to be a UUID but doesn't parse to a Java UUID, so use String.
    private String couchRev;

    public String getCouchId() {
        return couchId;
    }

    public void setCouchId(String couchId) {
        this.couchId = couchId;
    }

    public String getCouchRev() {
        return couchRev;
    }

    public void setCouchRev(String couchRev) {
        this.couchRev = couchRev;
    }
}
