package com.opower.couchdb_talk.dao;

import com.opower.couchdb_talk.model.Artist;
import java.util.List;
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
    public void saveBulkArtists(List<Artist> artists) {
        LOGGER.log(Level.FINE, "Saving {0} artists", artists.size());
        
        List<Response> bulkResponses = couchDbClient.bulk(artists, true);
        
        LOGGER.log(Level.INFO, "Saved artists with responses:");
        for (Response response : bulkResponses) {
            LOGGER.log(Level.INFO, "Response {0}", response.toString());
        }
    }
    
    @Override
    public void runDiagnostics() {
        LOGGER.log(Level.INFO, "Base URI = {0}", couchDbClient.getBaseUri());
        LOGGER.log(Level.INFO, "DB URI = {0}", couchDbClient.getDBUri());
        LOGGER.log(Level.INFO, "GSON = {0}", couchDbClient.getGson());
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
