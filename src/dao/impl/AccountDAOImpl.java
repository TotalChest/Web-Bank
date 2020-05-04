package dao.impl;

import dao.DAOHelpers;
import dao.AccountDAO;
import model.Account;
import model.Operation;
import model.Customer;
import model.TypeOfAccount;
import model.Department;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ObjectNotFoundException;

import java.sql.SQLException;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    public List getAllAccounts() throws SQLException {
        List accounts;
        accounts = DAOHelpers.ExecuteInSession(session -> session.createCriteria(Account.class).list());
        return accounts;
    }

    public Account getAccountById(Integer accountId) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (Account) session.get(Account.class, accountId));
    }

    public int addAccount(Account w) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (int) session.save(w));
    }

    public void updateAccount(Account w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.update(w));
    }

    public void deleteAccount(Account w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            w.getCustomer().getAccountSet().remove(w);
            session.update(w.getCustomer());
            w.getType().getAccountSet().remove(w);
            session.update(w.getType());
            w.getInterestAccount().getAccountSet().remove(w);
            session.update(w.getInterestAccount());
            w.getDepartment().getAccountSet().remove(w);
            session.update(w.getDepartment());
            for (Operation entry : w.getOperationSet()) {
                entry.setAccount(null);
                session.update(entry);
            }
            w.getOperationSet().clear();
            for (Account entry : w.getAccountSet()) {
                entry.setInterestAccount(null);
                session.update(entry);
            }
            w.getAccountSet().clear();
            session.delete(w);
        });
    }

    public void deleteAccountById(int id) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            Account w = (Account) session.get(Account.class, id);
            if(w != null) {
                w.getCustomer().getAccountSet().remove(w);
                session.update(w.getCustomer());
                w.getType().getAccountSet().remove(w);
                session.update(w.getType());
                w.getInterestAccount().getAccountSet().remove(w);
                session.update(w.getInterestAccount());
                w.getDepartment().getAccountSet().remove(w);
                session.update(w.getDepartment());
                for (Operation entry : w.getOperationSet()) {
                    entry.setAccount(null);
                    session.update(entry);
                }
                w.getOperationSet().clear();
                for (Account entry : w.getAccountSet()) {
                    entry.setInterestAccount(null);
                    session.update(entry);
                }
                w.getAccountSet().clear();
            }
            session.delete(w);
        });
    }
}
