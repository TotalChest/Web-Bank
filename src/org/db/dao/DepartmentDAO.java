package org.db.dao;

import org.db.model.Department;

import java.sql.SQLException;
import java.util.List;


public interface DepartmentDAO {
    List getAllDepartments() throws SQLException;

    Department getDepartmentById(Integer departmentId) throws SQLException;

    int addDepartment(Department w) throws SQLException;

    void updateDepartment(Department w) throws SQLException;

    void deleteDepartment(Department w) throws SQLException;

    void deleteDepartmentById(int id) throws SQLException;

}
