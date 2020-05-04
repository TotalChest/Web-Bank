package dao.impl;

import dao.DAOHelpers;
import dao.TypeOfAccountDAO;
import model.TypeOfAccount;
import model.Account;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ObjectNotFoundException;

import java.sql.SQLException;
import java.util.List;


public class TypeOfAccountDAOImpl implements TypeOfAccountDAO {
    public List getAllTypesOfAccount() throws SQLException {
        List types;
        types = DAOHelpers.ExecuteInSession(session -> session.createCriteria(TypeOfAccount.class).list());
        return types;
    }

    public TypeOfAccount getTypeOfAccountById(Integer typeId) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (TypeOfAccount) session.get(TypeOfAccount.class, typeId));
    }

    public int addTypeOfAccount(TypeOfAccount w) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (int) session.save(w));
    }

    public void updateTypeOfAccount(TypeOfAccount w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.update(w));
    }

    public void deleteTypeOfAccount(TypeOfAccount w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            for (Account entry : w.getAccountSet()) {
                entry.setType(null);
                session.update(entry);
            }
            w.getAccountSet().clear();
            session.delete(w);
        });
    }

    public void deleteTypeOfAccountById(int id) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            TypeOfAccount w = (TypeOfAccount) session.get(TypeOfAccount.class, id);
            if(w != null) {
                for (Account entry : w.getAccountSet()) {
                    entry.setType(null);
                    session.update(entry);
                }
                w.getAccountSet().clear();
            }
            session.delete(w);
        });
    }
}

