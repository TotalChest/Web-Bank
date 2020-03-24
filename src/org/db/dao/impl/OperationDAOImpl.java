package org.db.dao.impl;

import org.db.dao.OperationDAO;
import org.db.dao.DAOHelpers;
import org.db.model.Operation;
import org.db.model.Account;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ObjectNotFoundException;

import java.sql.SQLException;
import java.util.List;

public class OperationDAOImpl implements OperationDAO {
    public List getAllOperations() throws SQLException {
        List operations;
        operations = DAOHelpers.ExecuteInSession(session -> session.createCriteria(Operation.class).list(), false);
        return operations;
    }

    public Operation getOperationById(Integer operationId) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (Operation) session.load(Operation.class, operationId), false);
    }

    public int addOperation(Operation w) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (int) session.save(w), true);
    }

    public void updateOperation(Operation w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.update(w), true);
    }

    public void deleteOperation(Operation w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            w.getAccount().getOperationSet().remove(w);
            session.save(w.getAccount());
            session.delete(w);
        }, true);
    }

    public void deleteOperationById(int id) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            Operation w = (Operation) session.load(Operation.class, id);
            w.getAccount().getOperationSet().remove(w);
            session.save(w.getAccount());
            session.delete(w);
        }, true);
    }
}
