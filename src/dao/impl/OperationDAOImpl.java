package dao.impl;

import dao.OperationDAO;
import dao.DAOHelpers;
import model.Operation;
import model.Account;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ObjectNotFoundException;

import java.sql.SQLException;
import java.util.List;

public class OperationDAOImpl implements OperationDAO {
    public List getAllOperations() throws SQLException {
        List operations;
        operations = DAOHelpers.ExecuteInSession(session -> session.createCriteria(Operation.class).list());
        return operations;
    }

    public Operation getOperationById(Integer operationId) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (Operation) session.get(Operation.class, operationId));
    }

    public int addOperation(Operation w) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (int) session.save(w));
    }

    public void updateOperation(Operation w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.update(w));
    }

    public void deleteOperation(Operation w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            w.getAccount().getOperationSet().remove(w);
            session.update(w.getAccount());
            session.delete(w);
        });
    }

    public void deleteOperationById(int id) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            Operation w = (Operation) session.get(Operation.class, id);
            if(w != null) {
                w.getAccount().getOperationSet().remove(w);
                session.update(w.getAccount());
            }
            session.delete(w);
        });
    }
}
