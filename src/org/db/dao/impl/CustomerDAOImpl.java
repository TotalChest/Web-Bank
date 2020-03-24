package org.db.dao.impl;

import org.db.dao.DAOHelpers;
import org.db.dao.CustomerDAO;
import org.db.model.Customer;
import org.db.model.Account;
import org.db.model.Contact;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.sql.SQLException;
import java.util.List;


public class CustomerDAOImpl implements CustomerDAO {
    public List getAllCustomers() throws SQLException {
        List customers;
        customers = DAOHelpers.ExecuteInSession(session -> session.createCriteria(Customer.class).list(), false);
        return customers;
    }

    public Customer getCustomerById(Integer customerId) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (Customer) session.load(Customer.class,customerId), false);
    }

    public int addCustomer(Customer w) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (int) session.save(w), true);
    }

    public void updateCustomer(Customer w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.update(w), true);
    }

    public void deleteCustomer(Customer w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            for (Account entry : w.getAccountSet()) {
                entry.setCustomer(null);
                session.save(entry);
            }
            w.getAccountSet().clear();
            for (Contact entry : w.getContactSet()) {
                entry.setCustomer(null);
                session.save(entry);
            }
            w.getContactSet().clear();
            session.delete(w);
        }, true);
    }

    public void deleteCustomerById(int id) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            Customer w = (Customer) session.load(Customer.class, id);
            for (Account entry : w.getAccountSet()) {
                entry.setCustomer(null);
                session.save(entry);
            }
            w.getAccountSet().clear();
            for (Contact entry : w.getContactSet()) {
                entry.setCustomer(null);
                session.save(entry);
            }
            w.getContactSet().clear();
            session.delete(w);
        }, true);
    }
}
