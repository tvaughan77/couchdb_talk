package com.opower.couchdb_talk.dao;

import com.opower.couchdb_talk.model.Artist;
import java.util.List;

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
    
    /**
     * Executes a bulk update of a List of Artists
     * @param artists
     */
    void saveBulkArtists(List<Artist> artists);

    /**
     * @param artist Saves an artist
     */
    void saveArtist(Artist artist);
}
