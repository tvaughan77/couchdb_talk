package com.opower.couchdb_talk;

import com.opower.couchdb_talk.dao.MusicDAO;
import com.opower.couchdb_talk.model.Artist;
import com.opower.couchdb_talk.xml.XmlLoader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tomvaughan
 */
public class Driver {
    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
    private MusicDAO dao;
    private XmlLoader xmlLoader;
    
    public void doStuff() {
        runDiagnostics();
        
        List<Artist> artists = loadArtists();
        
        saveArtists(artists);
        
        saveArtist(artists.get(0));
        
    }
    
    private void runDiagnostics() {
        dao.runDiagnostics();
    }

    private List<Artist> loadArtists() {
        LOGGER.log(Level.INFO, "Loading artists");
        List<Artist> artists = xmlLoader.getArtists();
        LOGGER.log(Level.INFO, "There are {0} artists", artists.size());
        return artists;
    }
    
    private void saveArtist(Artist artist) {
        this.dao.saveArtist(artist);
    }
    
    private void saveArtists(List<Artist> artists) {
        this.dao.saveBulkArtists(artists);
    }
    
    @Autowired
    public void setMusicDAO(MusicDAO dao) {
        this.dao = dao;
    }
    
    @Autowired
    public void setXmlLoader(XmlLoader xmlLoader) {
        this.xmlLoader = xmlLoader;
    }

}
