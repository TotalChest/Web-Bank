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
        TypeOfAccountDAO typeOfAccountDAO = DAOFactory.getInstance().getTypeOfAccountDAO();
        TypeOfAccount t = typeOfAccountDAO.getTypeOfAccountById(2);
        System.out.println(t.getType());
    }
}