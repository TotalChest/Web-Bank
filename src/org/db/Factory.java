package org.db;

import org.db.dao.ContactDAO;
import org.db.dao.impl.ContactDAOImpl;

public class Factory {
    private static ContactDAO contactDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public ContactDAO getContactDAO(){
        if (contactDAO == null){
            contactDAO = new ContactDAOImpl();
        }
        return contactDAO;
    }
}
