package dao;

import model.Contact;
import model.Customer;

import java.sql.SQLException;
import java.util.List;


public interface ContactDAO {

    List getAllContacts() throws SQLException;

    Contact getContactById(Integer contactId) throws SQLException;

    int addContact(Contact w) throws SQLException;

    void updateContact(Contact w) throws SQLException;

    void deleteContact(Contact w) throws SQLException;

    void deleteContactById(int id) throws SQLException;
}
