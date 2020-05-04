package dao.impl;

import dao.DAOHelpers;
import dao.DepartmentDAO;
import model.Account;
import model.Department;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ObjectNotFoundException;

import java.sql.SQLException;
import java.util.List;


public class DepartmentDAOImpl implements DepartmentDAO {

    public List getAllDepartments() throws SQLException {
        List departments;
        departments = DAOHelpers.ExecuteInSession(session -> session.createCriteria(Department.class).list());
        return departments;
    }

    public Department getDepartmentById(Integer departmentId) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (Department) session.get(Department.class, departmentId));
    }

    public int addDepartment(Department w) throws SQLException {
        return DAOHelpers.ExecuteInSession(session -> (int) session.save(w));
    }

    public void updateDepartment(Department w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.update(w));
    }

    public void deleteDepartment(Department w) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            w.getAccountSet().clear();
            session.delete(w);
        });
    }

    public void deleteDepartmentById(int id) throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> {
            Department w = (Department) session.get(Department.class, id);
            if(w != null) {
                w.getAccountSet().clear();
            }
            session.delete(w);
        });
    }
}
