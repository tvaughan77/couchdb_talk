package com.opower.couchdb_talk.dao;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>Implementation of the MusicDAO with CouchDB client</p>
 * @author tomvaughan
 */
@Repository("MusicDAO")
public class MusicCouchDbDao implements MusicDAO {
    
    private CouchDbClient couchDbClient;
    
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
