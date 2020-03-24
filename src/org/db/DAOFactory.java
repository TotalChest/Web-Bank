package org.db;

import org.db.dao.AccountDAO;
import org.db.dao.ContactDAO;
import org.db.dao.CustomerDAO;
import org.db.dao.DepartmentDAO;
import org.db.dao.OperationDAO;
import org.db.dao.TypeOfAccountDAO;
import org.db.dao.impl.AccountDAOImpl;
import org.db.dao.impl.ContactDAOImpl;
import org.db.dao.impl.CustomerDAOImpl;
import org.db.dao.impl.DepartmentDAOImpl;
import org.db.dao.impl.OperationDAOImpl;
import org.db.dao.impl.TypeOfAccountDAOImpl;


public class DAOFactory {
    private static AccountDAO accountDAO = null;
    private static ContactDAO contactDAO = null;
    private static CustomerDAO customerDAO = null;
    private static DepartmentDAO departmentDAO = null;
    private static OperationDAO operationDAO = null;
    private static TypeOfAccountDAO typeOfAccountDAO = null;
    private static DAOFactory instance = null;

    public static synchronized DAOFactory getInstance(){
        if (instance == null){
            instance = new DAOFactory();
        }
        return instance;
    }

    public AccountDAO getAccountDAO(){
        if (accountDAO == null){
            accountDAO = new AccountDAOImpl();
        }
        return accountDAO;
    }

    public ContactDAO getContactDAO(){
        if (contactDAO == null){
            contactDAO = new ContactDAOImpl();
        }
        return contactDAO;
    }

    public static CustomerDAO getCustomerDAO() {
        if (customerDAO == null){
            customerDAO = new CustomerDAOImpl();
        }
        return customerDAO;
    }

    public static DepartmentDAO getDepartmentDAO() {
        if (departmentDAO == null){
            departmentDAO = new DepartmentDAOImpl();
        }
        return departmentDAO;
    }

    public static OperationDAO getOperationDAO(){
        if (operationDAO == null){
            operationDAO = new OperationDAOImpl();
        }
        return operationDAO;
    }

    public static TypeOfAccountDAO getTypeOfAccountDAO(){
        if (typeOfAccountDAO == null){
            typeOfAccountDAO = new TypeOfAccountDAOImpl();
        }
        return typeOfAccountDAO;
    }
}