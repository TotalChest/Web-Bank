package org.db.dao;


import org.db.model.TypeOfAccount;

import java.sql.SQLException;
import java.util.List;

public interface TypeOfAccountDAO {
    List getAllTypesOfAccount() throws SQLException;

    TypeOfAccount getTypeOfAccountById(Integer typeOfAccountId) throws SQLException;

    int addTypeOfAccount(TypeOfAccount w) throws SQLException;

    void updateTypeOfAccount(TypeOfAccount w) throws SQLException;

    void deleteTypeOfAccount(TypeOfAccount w) throws SQLException;

    void deleteTypeOfAccountById(int id) throws SQLException;
}
