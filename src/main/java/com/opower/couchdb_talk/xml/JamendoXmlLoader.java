package com.opower.couchdb_talk.xml;

import com.opower.couchdb_talk.model.Artist;
import com.opower.couchdb_talk.model.JamendoData;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.springframework.beans.factory.annotation.Required;

/**
 * <p>Loads XML from http://developer.jamendo.com/en/wiki/NewDatabaseDumps into POJOs</p>
 * @author tomvaughan
 */
public class JamendoXmlLoader implements XmlLoader {
    
    private static final String FILE_NAME = "dbdump_artistalbumtrack_100k_lines.xml";
    private static final Logger LOGGER = Logger.getLogger(JamendoXmlLoader.class.getName());
    private List<Artist> artists;
    private String filename;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    
    private void loadArtists() throws IOException, JAXBException {
        InputStream is = null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream(this.filename);
            JamendoData jamendoData = (JamendoData) this.unmarshaller.unmarshal(new StreamSource(is));
            this.artists = jamendoData.getArtists();
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
    
    @Override
    public List<Artist> getArtists() {
        if (artists == null) {
            try {
                this.loadArtists();
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            } catch (JAXBException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
        return artists;
    }

    @Required
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    @Required
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
    
    @Required
    public void setXmlDataSourceFile(String file) {
        this.filename = file;
    }
}
