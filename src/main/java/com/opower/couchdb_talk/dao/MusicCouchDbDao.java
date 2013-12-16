package com.opower.couchdb_talk.dao;

import com.opower.couchdb_talk.model.Artist;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
    public Artist saveArtist(Artist artist) {
        LOGGER.log(Level.FINE, "Saving artist {0}", artist.getId());
        
        Response response = couchDbClient.save(artist);
        Artist updatedArtist = updateArtistWithResponse(artist, response);
        
        LOGGER.log(Level.INFO, "Saved artist {0} with response {1}", new Object[]{artist.getId(), response.toString()});
        
        return updatedArtist;
    }
    
    @Override
    public List<Artist> saveBulkArtists(List<Artist> artists) {
        LOGGER.log(Level.FINE, "Saving {0} artists", artists.size());
        
        List<Response> bulkResponses = couchDbClient.bulk(artists, true);

        /*
         * WARNING: There is a *huge* assumption here that the underlying couchDbClient.bulk( ) call returns responses in
         * order with the list of artists we're inserting.  This appears to be true with the "all-or-nothing" semantics, but
         * we probably can't count on it, nor do we know how it behaves when "all-or-nothing" is set to false.
         */
        List<Artist> updatedArtists = new ArrayList<Artist>();
        for (int i=0; i<artists.size(); i++) {
            Artist artist = artists.get(i);
            Response response = bulkResponses.get(i);
            LOGGER.log(Level.INFO, "Saved artist {0} with response {1}", new Object[]{artist.getName(), response.getId()});
            updatedArtists.add(updateArtistWithResponse(artist, response));
        }
        
        return updatedArtists;
    }
    
    private Artist updateArtistWithResponse(Artist artist, Response response) {
        artist.setCouchId(response.getId());
        artist.setCouchRev(response.getRev());
        return artist;
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
