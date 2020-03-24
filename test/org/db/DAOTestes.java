package org.db;

import org.db.dao.*;
import org.db.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAOTests {
    private AccountDAO accountDAO = DAOFactory.getInstance().getAccountDAO();
    private ContactDAO contactDAO = DAOFactory.getInstance().getContactDAO();
    private CustomerDAO customerDAO = DAOFactory.getInstance().getCustomerDAO();
    private DepartmentDAO departmentDAO = DAOFactory.getInstance().getDepartmentDAO();
    private OperationDAO operationDAO = DAOFactory.getInstance().getOperationDAO();
    private TypeOfAccountDAO typeOfAccountDAO = DAOFactory.getInstance().getTypeOfAccountDAO();
}