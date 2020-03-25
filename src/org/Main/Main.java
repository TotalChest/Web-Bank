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
            Account acc = factory.getAccountDAO().getAccountById(2);
            System.out.println(acc.getNumber());
            System.out.println(acc.getBalance());
            System.out.println(acc.getDate());
        }
    }
}