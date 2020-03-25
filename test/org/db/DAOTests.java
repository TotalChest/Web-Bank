package org.db;

import org.db.dao.*;
import org.db.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.sql.Timestamp;

public class DAOTests {
    private DepartmentDAO departmentDAO = DAOFactory.getInstance().getDepartmentDAO();
    private AccountDAO accountDAO = DAOFactory.getInstance().getAccountDAO();
    private ContactDAO contactDAO = DAOFactory.getInstance().getContactDAO();
    private CustomerDAO customerDAO = DAOFactory.getInstance().getCustomerDAO();
    private OperationDAO operationDAO = DAOFactory.getInstance().getOperationDAO();
    private TypeOfAccountDAO typeOfAccountDAO = DAOFactory.getInstance().getTypeOfAccountDAO();

    @Test
    public void testAccount() throws SQLException {
        int size = accountDAO.getAllAccounts().size();
        Assert.assertEquals(size, 9);

        Assert.assertEquals(accountDAO.getAccountById(1).getNumber(), "9008007001");

        Account a = new Account();
        a.setNumber("8008707005");
        a.setCustomer(customerDAO.getCustomerById(1));
        a.setBalance(Float.valueOf(100000));
        a.setType(typeOfAccountDAO.getTypeOfAccountById(4));
        a.setInterestAccount(accountDAO.getAccountById(1));
        a.setDepartment(departmentDAO.getDepartmentById(3));
        a.setDate(Timestamp.valueOf("2020-03-21 06:40:01.0"));
        int id = accountDAO.addAccount(a);
        Assert.assertEquals(size + 1, accountDAO.getAllAccounts().size());

        Float balance = accountDAO.getAccountById(id).getBalance();
        a.setBalance(Float.valueOf(55000));
        accountDAO.updateAccount(a);
        Assert.assertFalse(accountDAO.getAccountById(id).getBalance() == balance);

        accountDAO.deleteAccountById(a.getId());
        Assert.assertEquals(size, accountDAO.getAllAccounts().size());

        accountDAO.deleteAccount(accountDAO.getAccountById(2));
        Assert.assertEquals(size - 1, accountDAO.getAllAccounts().size());
    }

    private static Set<Integer> departmentIdSet = new HashSet<>();

    @Test
    public void testGetAll() throws SQLException {
        for (int i = 1; i <= 5; ++i) {
            Department d = departmentDAO.getDepartmentById(i);
            if (d != null) {
                departmentIdSet.add(d.getId());
            }
        }
        Assert.assertEquals(departmentDAO.getAllDepartments().size(), departmentIdSet.size());
        for (Object d : departmentDAO.getAllDepartments()) {
            Assert.assertTrue(departmentIdSet.contains(((Department) d).getId()));
        }
    }

    @Test
    public void testAdd() throws SQLException {
        Department d = new Department();
        d.setName("Сбербанк Технологии");
        d.setAdress("Ул. Тверская, 25 ст. 4");
        int oldSize = departmentDAO.getAllDepartments().size();
        int id = departmentDAO.addDepartment(d);
        int newSize = departmentDAO.getAllDepartments().size();
        Department d1 = departmentDAO.getDepartmentById(id);

        Assert.assertEquals(d.getName(), d1.getName());
        Assert.assertEquals(d.getAdress(), d1.getAdress());
        Assert.assertEquals(newSize, oldSize + 1);

        departmentIdSet.add(id);
    }

    @Test(expected = SQLException.class)
    public void testAddNoRequiredField() throws SQLException {
        Department d = new Department();
        departmentDAO.addDepartment(d);
    }

    @Test
    public void testDelete() throws SQLException {
        Operation o = (Operation) operationDAO.getAllOperations().get(0);
        int id = o.getId();
        int oldSize = operationDAO.getAllOperations().size();
        operationDAO.deleteOperation(o);
        int newSize = operationDAO.getAllOperations().size();

        Assert.assertNull(operationDAO.getOperationById(id));
        Assert.assertEquals(newSize, oldSize - 1);
    }

    @Test
    public void testDeleteById() throws SQLException {
        Account a = (Account) accountDAO.getAllAccounts().get(6);
        int id = a.getId();
        int oldSize = accountDAO.getAllAccounts().size();
        accountDAO.deleteAccountById(id);
        int newSize = accountDAO.getAllAccounts().size();

        Assert.assertNull(accountDAO.getAccountById(id));
        Assert.assertEquals(newSize, oldSize - 1);
    }

    @Test(expected = SQLException.class)
    public void testDeleteNull() throws SQLException {
        customerDAO.deleteCustomer(null);
    }

    @Test(expected = SQLException.class)
    public void testDeleteNonExistent() throws SQLException {
        Customer c = new Customer();
        c.setId(10000000);
        customerDAO.deleteCustomer(c);
    }

    @Test(expected = SQLException.class)
    public void testDeleteByIdNonExistent() throws SQLException {
        typeOfAccountDAO.deleteTypeOfAccountById(2000000);
    }

    @Test
    public void testUpdate() throws SQLException {
        Customer c = customerDAO.getCustomerById(1);
        int oldSize = customerDAO.getAllCustomers().size();
        c.setDateOfRegistration(Timestamp.valueOf("2019-07-11 13:00:18.0"));
        customerDAO.updateCustomer(c);
        int newSize = customerDAO.getAllCustomers().size();
        c = customerDAO.getCustomerById(1);
        Timestamp date = c.getDateOfRegistration();

        Assert.assertEquals(oldSize, newSize);
        Assert.assertNotNull(date);
        Assert.assertEquals(date, Timestamp.valueOf("2019-07-11 13:00:18.0"));
    }

    @Test(expected = SQLException.class)
    public void testUpdateNull() throws SQLException {
        contactDAO.updateContact(null);
    }

    @Test(expected = SQLException.class)
    public void testUpdateNonExistent() throws SQLException {
        TypeOfAccount t = new TypeOfAccount();
        typeOfAccountDAO.updateTypeOfAccount(t);
    }
/*
    @Test(expected = SQLException.class)
    public void testUpdateNoRequiredField() throws SQLException {
        Customer c = customerDAO.getCustomerById(0);
        c.setType(null);
        customerDAO.updateCustomer(c);
    }
*/
    @Test
    public void testGetById() throws SQLException {
        Account a = accountDAO.getAccountById(6);

        Assert.assertEquals(a.getNumber(), "9008007006");
        Assert.assertEquals(a.getCustomer().getId(), Integer.valueOf(3));
        Assert.assertEquals(a.getInterestAccount().getId(), Integer.valueOf(5));
        Assert.assertEquals(a.getBalance(), Float.valueOf(18000));
        Assert.assertEquals(a.getDate(), Timestamp.valueOf("2020-02-05 16:58:45.0"));

        a = accountDAO.getAccountById(2000000);
        Assert.assertNull(a);
    }
/*
    @Test
    public void testVacancyMatchers() {
        Company c1 = new Company();
        {
            c1.setId(1);
            c1.setAddress("1");
            c1.setName("1");
        }
        Company c2 = new Company();
        {
            c2.setId(2);
            c2.setAddress("2");
            c2.setName("2");
        }
        Company c3 = new Company();
        {
            c3.setId(3);
            c3.setAddress("3");
            c3.setName("3");
        }
        Vacancy v = new Vacancy();
        {
            v.setId(1);
            v.setMaxSalary(2000);
            v.setPosition("president");
            v.setMinSalary(500);
            v.setMinEducationLevel(EducationLevel.MASTERS);
            v.setCompany(c1);
            v.setPrevCompanyReq(c1);
            v.setPrevPositionReq("governor");
        }
        Worker w = new Worker();
        {
            w.setId(1);
            w.setAddress("1");
            w.setFirstName("Vladimir");
            w.setLastName("Putin");
            w.setEducationLevel(EducationLevel.DOCTORATE);
            w.setLookingForJob(true);
            w.setMinSalaryReq(1234);
            w.setPhoneNumber("1");
            w.setPositionReq("president");
        }
        JobHistory h1 = new JobHistory();
        {
            h1.setId(1);
            h1.setWorker(w);
            h1.setCompany(c3);
            h1.setPosition("Governor");
            h1.setSalary(1);
        }
        JobHistory h2 = new JobHistory();
        {
            h2.setId(2);
            h2.setWorker(w);
            h2.setCompany(c1);
            h2.setPosition("Janitor");
            h2.setSalary(123);
        }
        w.getHistoryEntries().add(h1);
        w.getHistoryEntries().add(h2);

        Assert.assertTrue(v.matchesWorker(w));
        Assert.assertEquals(v.matchesWorker(w), w.matchesVacancy(v));

        w.setPositionReq("President");
        Assert.assertTrue(v.matchesWorker(w));

        v.setPrevCompanyReq(c2);
        Assert.assertFalse(v.matchesWorker(w));
        v.setPrevCompanyReq(c1);

        w.setEducationLevel(EducationLevel.LESS);
        Assert.assertFalse(w.matchesVacancy(v));
        w.setEducationLevel(EducationLevel.DOCTORATE);

        w.setLookingForJob(false);
        Assert.assertFalse(v.matchesWorker(w));
        w.setLookingForJob(true);

        w.getHistoryEntries().remove(h2);
        Assert.assertFalse(v.matchesWorker(w));
        w.getHistoryEntries().add(h2);

        v.setMinSalary(null);
        Assert.assertTrue(v.matchesWorker(w));

        w.setMinSalaryReq(0);
        Assert.assertTrue(v.matchesWorker(w));

        w.setPositionReq(null);
        Assert.assertTrue(v.matchesWorker(w));

        v.setPrevCompanyReq(null);
        Assert.assertTrue(v.matchesWorker(w));

        v.setPrevPositionReq(null);
        Assert.assertTrue(v.matchesWorker(w));

        w.setMinSalaryReq(10000000);
        Assert.assertFalse(v.matchesWorker(w));
        w.setMinSalaryReq(0);

        w.setPositionReq("persident");
        Assert.assertFalse(v.matchesWorker(w));
        w.setPositionReq("president");
    }

    @Test
    public void testDAOHelpers() throws SQLException {
        List workers = DAOHelpers.ExecuteInSession(session -> session.createQuery("from Worker").list());
        Set<Integer> ids = new HashSet<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        for (Object w : workers) {
            Assert.assertTrue(ids.contains(((Worker) w).getId()));
        }
    }

    @Test
    public void testDAOHelpersTransactional() throws SQLException {
        boolean isActive = DAOHelpers.ExecuteInSession(session -> session.getTransaction().isActive());
        Assert.assertTrue(isActive);
    }

    @Test(expected = SQLException.class)
    public void testDAOHelpersException() throws SQLException {
        DAOHelpers.ExecuteInSessionVoidRet(session -> session.getTransaction().rollback());
    }


    @Test
    public void testEnumOperationType() throws SQLException{
        int credit = 0, debit = 0;
        Assert.assertEquals(operationDAO.getOperationById(1).getOperation(), OperationType.CREDIT);
       // for(int i = 1; i < 7; ++i){
         //   if(operationDAO.getOperationById(i).getOperation().getValue() == 0)
           //     ++credit;
           // else
             //   ++debit;
        //}
    }
*/
}