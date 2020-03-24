package org.db.dao.impl;

import org.db.dao.DAOHelpers;
import org.db.dao.ContactDAO;
import org.db.model.Contact;
import org.db.model.Customer;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ObjectNotFoundException;

import java.sql.SQLException;
import java.util.List;


public class ContactDAOImpl implements ContactDAO {
    public List getAllContacts() throws SQLException {
        List contacts;
        contacts = DAOHelpers.ExecuteInSession(session -> session.createCriteria(Contact.class).list(), false);
        return contacts;
    }

    public Contact getContactById(Integer contactId) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (Contact) session.load(Contact.class, contactId), false);
    }

    public int addContact(Contact w) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (int) session.save(w), true);
    }

    public void updateContact(Contact w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.update(w), true);
    }

    public void deleteContact(Contact w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            w.getCustomer().getContactSet().remove(w);
            session.save(w.getCustomer());
            session.delete(w);
        }, true);
    }

    public void deleteContactById(int id) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            Contact w = (Contact) session.load(Contact.class, id);
            w.getCustomer().getContactSet().remove(w);
            session.save(w.getCustomer());
            session.delete(w);
        }, true);
    }
}