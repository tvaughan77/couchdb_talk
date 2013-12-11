package com.opower.couchdb_talk.dao;

import com.opower.couchdb_talk.model.Artist;

/**
 * <p>Contract for working with a DataAccesObject to manipulate our Music objects</p>
 * @author tomvaughan
 */
public interface MusicDAO {
    
    /**
     * print some simple shit out to see if the configuraiton is ok
     */
    void runDiagnostics();

    /**
     * @return the design of the underlying CouchDB database
     */
    String getDesign();

    void saveArtist(Artist artist);
}
