package dao;

import model.Account;
import model.Customer;
import model.TypeOfAccount;
import model.Department;

import java.sql.SQLException;
import java.util.List;


public interface AccountDAO {

    List getAllAccounts() throws SQLException;

    Account getAccountById(Integer accountId) throws SQLException;

    int addAccount(Account w) throws SQLException;

    void updateAccount(Account w) throws SQLException;

    void deleteAccount(Account w) throws SQLException;

    void deleteAccountById(int id) throws SQLException;
}