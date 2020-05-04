package dao;

import model.Customer;

import java.sql.SQLException;
import java.util.List;


public interface CustomerDAO {
    List getAllCustomers() throws SQLException;

    Customer getCustomerById(Integer customerId) throws SQLException;

    int addCustomer(Customer w) throws SQLException;

    void updateCustomer(Customer w) throws SQLException;

    void deleteCustomer(Customer w) throws SQLException;

    void deleteCustomerById(int id) throws SQLException;
}
