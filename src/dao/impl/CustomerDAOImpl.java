package dao.impl;

import dao.DAOHelpers;
import dao.CustomerDAO;
import model.Customer;
import model.Account;
import model.Contact;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.sql.SQLException;
import java.util.List;


public class CustomerDAOImpl implements CustomerDAO {
    public List getAllCustomers() throws SQLException {
        List customers;
        customers = DAOHelpers.ExecuteInSession(session -> session.createCriteria(Customer.class).list());
        return customers;
    }

    public Customer getCustomerById(Integer customerId) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (Customer) session.get(Customer.class, customerId));
    }

    public int addCustomer(Customer w) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (int) session.save(w));
    }

    public void updateCustomer(Customer w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.update(w));
    }

    public void deleteCustomer(Customer w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            for (Account entry : w.getAccountSet()) {
                entry.setCustomer(null);
                session.update(entry);
            }
            w.getAccountSet().clear();
            for (Contact entry : w.getContactSet()) {
                entry.setCustomer(null);
                session.update(entry);
            }
            w.getContactSet().clear();
            session.delete(w);
        });
    }

    public void deleteCustomerById(int id) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            Customer w = (Customer) session.get(Customer.class, id);
            if(w != null) {
                for (Account entry : w.getAccountSet()) {
                    entry.setCustomer(null);
                    session.update(entry);
                }
                w.getAccountSet().clear();
                for (Contact entry : w.getContactSet()) {
                    entry.setCustomer(null);
                    session.update(entry);
                }
                w.getContactSet().clear();
            }
            session.delete(w);
        });
    }
}
