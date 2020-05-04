package dao.impl;

import dao.DAOHelpers;
import dao.ContactDAO;
import model.Contact;
import model.Customer;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ObjectNotFoundException;

import java.sql.SQLException;
import java.util.List;


public class ContactDAOImpl implements ContactDAO {
    public List getAllContacts() throws SQLException {
        List contacts;
        contacts = DAOHelpers.ExecuteInSession(session -> session.createCriteria(Contact.class).list());
        return contacts;
    }

    public Contact getContactById(Integer contactId) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (Contact) session.get(Contact.class, contactId));
    }

    public int addContact(Contact w) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (int) session.save(w));
    }

    public void updateContact(Contact w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.update(w));
    }

    public void deleteContact(Contact w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            w.getCustomer().getContactSet().remove(w);
            w.setCustomer(null);
            session.delete(w);
        });
    }

    public void deleteContactById(int id) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            Contact w = (Contact) session.get(Contact.class, id);
            if(w != null) {
                w.getCustomer().getContactSet().remove(w);
                w.setCustomer(null);
            }
            session.delete(w);
        });
    }
}