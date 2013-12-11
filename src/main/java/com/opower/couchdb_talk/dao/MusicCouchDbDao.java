package com.opower.couchdb_talk.dao;

import com.opower.couchdb_talk.model.Artist;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbDesign;
import org.lightcouch.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>Implementation of the MusicDAO with CouchDB client</p>
 * @author tomvaughan
 */
@Repository("MusicDAO")
public class MusicCouchDbDao implements MusicDAO {
    
    private static final Logger LOGGER = Logger.getLogger(MusicCouchDbDao.class.getName());
    private CouchDbClient couchDbClient;
    
    
    @Override
    public void saveArtist(Artist artist) {
        LOGGER.log(Level.FINE, "Saving artist {0}", artist.getId());
        Response response = couchDbClient.save(artist);
        LOGGER.log(Level.INFO, "Saved artist {0} with response {1}", new Object[]{artist.getId(), response.toString()});
        
    }
    @Override
    public void runDiagnostics() {
        System.out.println("Base URI = " + couchDbClient.getBaseUri());
        System.out.println("DB URI = " + couchDbClient.getDBUri());
        System.out.println("GSON = " + couchDbClient.getGson());
    }
    
    @Override
    public String getDesign( ) {
        CouchDbDesign design = couchDbClient.design();
        return design.toString();
    }
    
    @Autowired
    public void setCouchDbClient(CouchDbClient couchDbClient) {
        this.couchDbClient = couchDbClient;
    }
}
