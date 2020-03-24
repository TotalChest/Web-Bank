package org.db.dao;

import org.db.model.Operation;
import org.db.model.Account;

import java.sql.SQLException;
import java.util.List;


public interface OperationDAO {
    List getAllOperations() throws SQLException;

    Operation getOperationById(Integer operationId) throws SQLException;

    int addOperation(Operation w) throws SQLException;

    void updateOperation(Operation w) throws SQLException;

    void deleteOperation(Operation w) throws SQLException;

    void deleteOperationById(int id) throws SQLException;
}
