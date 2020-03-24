package org.db.dao.impl;

import org.db.dao.DAOHelpers;
import org.db.dao.TypeOfAccountDAO;
import org.db.model.TypeOfAccount;
import org.db.model.Account;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ObjectNotFoundException;

import java.sql.SQLException;
import java.util.List;


public class TypeOfAccountDAOImpl implements TypeOfAccountDAO {
    public List getAllTypesOfAccount() throws SQLException {
        List types;
        types = DAOHelpers.ExecuteInSession(session -> session.createCriteria(TypeOfAccount.class).list(), false);
        return types;
    }

    public TypeOfAccount getTypeOfAccountById(Integer typeId) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (TypeOfAccount) session.load(TypeOfAccount.class, typeId), false);
    }

    public int addTypeOfAccount(TypeOfAccount w) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (int) session.save(w), true);
    }

    public void updateTypeOfAccount(TypeOfAccount w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.update(w), true);
    }

    public void deleteTypeOfAccount(TypeOfAccount w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            for (Account entry : w.getAccountSet()) {
                entry.setType(null);
                session.save(entry);
            }
            w.getAccountSet().clear();
            session.delete(w);
        }, true);
    }

    public void deleteTypeOfAccountById(int id) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            TypeOfAccount w = (TypeOfAccount) session.load(TypeOfAccount.class, id);
            for (Account entry : w.getAccountSet()) {
                entry.setType(null);
                session.save(entry);
            }
            w.getAccountSet().clear();
            session.delete(w);
        }, true);
    }
}

