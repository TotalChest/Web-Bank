package org.Main;

import org.db.DAOFactory;
import org.db.dao.*;
import org.db.model.*;

import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args)  throws SQLException {
        DAOFactory factory = DAOFactory.getInstance();
        if(factory != null){
            System.out.println("DAOFactory done.");
            AccountDAO accountDAO = factory.getAccountDAO();
            Account a = (Account) accountDAO.getAccountById(8);
            System.out.println(accountDAO.getAllAccounts().size());
            accountDAO.deleteAccount(a);
            System.out.println(accountDAO.getAllAccounts().size());
           // accountDAO.deleteAccount(accountDAO.getAccountById(3));
            //System.out.println(accountDAO.getAllAccounts().size());
            /*int id = o.getId();
            System.out.println(id);
            int oldSize = operationDAO.getAllOperations().size();
            operationDAO.deleteOperationById(id);
            int newSize = operationDAO.getAllOperations().size();
            System.out.println(operationDAO.getOperationById(id));
            System.out.println(newSize);
            //Assert.assertNull(contactDAO.getContactById(id));
            //Assert.assertEquals(newSize, oldSize - 1);*/
        }
    }
}