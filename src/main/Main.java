package main;

import dao.*;
import model.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.sql.Timestamp;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        OperationDAO operationDAO = DAOFactory.getInstance().getOperationDAO();
        Operation o = operationDAO.getOperationById(6);
        System.out.println(o.getAccount().getNumber());
    }
}