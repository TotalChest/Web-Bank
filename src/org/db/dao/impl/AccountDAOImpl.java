package org.db.dao.impl;

import org.db.dao.DAOHelpers;
import org.db.dao.AccountDAO;
import org.db.model.Account;
import org.db.model.Operation;
import org.db.model.Customer;
import org.db.model.TypeOfAccount;
import org.db.model.Department;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ObjectNotFoundException;

import java.sql.SQLException;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    public List getAllAccounts() throws SQLException {
        List accounts;
        accounts = DAOHelpers.ExecuteInSession(session -> session.createCriteria(Account.class).list(), false);
        return accounts;
    }

    public Account getAccountById(Integer accountId) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (Account) session.load(Account.class, accountId), false);
    }

    public int addAccount(Account w) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (int) session.save(w), true);
    }

    public void updateAccount(Account w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.update(w), true);
    }

    public void deleteAccount(Account w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            w.getCustomer().getAccountSet().remove(w);
            session.save(w.getCustomer());
            w.getType().getAccountSet().remove(w);
            session.save(w.getType());
            w.getInterestAccount().getAccountSet().remove(w);
            session.save(w.getInterestAccount());
            w.getDepartment().getAccountSet().remove(w);
            session.save(w.getDepartment());
            for (Operation entry : w.getOperationSet()) {
                entry.setAccount(null);
                session.save(entry);
            }
            w.getOperationSet().clear();
            for (Account entry : w.getAccountSet()) {
                entry.setInterestAccount(null);
                session.save(entry);
            }
            w.getAccountSet().clear();
            session.delete(w);
        }, true);
    }

    public void deleteAccountById(int id) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            Account w = (Account) session.load(Account.class, id);
            w.getCustomer().getAccountSet().remove(w);
            session.save(w.getCustomer());
            w.getType().getAccountSet().remove(w);
            session.save(w.getType());
            w.getInterestAccount().getAccountSet().remove(w);
            session.save(w.getInterestAccount());
            w.getDepartment().getAccountSet().remove(w);
            session.save(w.getDepartment());
            for (Operation entry : w.getOperationSet()) {
                entry.setAccount(null);
                session.save(entry);
            }
            w.getOperationSet().clear();
            for (Account entry : w.getAccountSet()) {
                entry.setInterestAccount(null);
                session.save(entry);
            }
            w.getAccountSet().clear();
            session.delete(w);
        }, true);
    }
}
