package test;

import dao.*;
import model.*;
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

        Assert.assertEquals(accountDAO.getAccountById(2).getNumber(), "9008007002");

        Account a = new Account();
        a.setNumber("8008707005");
        a.setCustomer(customerDAO.getCustomerById(2));
        a.setBalance(Float.valueOf(100000));
        a.setType(typeOfAccountDAO.getTypeOfAccountById(2));
        a.setInterestAccount(accountDAO.getAccountById(2));
        a.setDepartment(departmentDAO.getDepartmentById(2));
        a.setDate(Timestamp.valueOf("2020-03-21 06:40:01.0"));
        int id = accountDAO.addAccount(a);
        Assert.assertEquals(size + 1, accountDAO.getAllAccounts().size());

        Float balance = accountDAO.getAccountById(id).getBalance();
        a.setBalance(Float.valueOf(55000));
        accountDAO.updateAccount(a);
        Assert.assertFalse(accountDAO.getAccountById(id).getBalance() == balance);

        accountDAO.deleteAccountById(a.getId());
        Assert.assertEquals(size, accountDAO.getAllAccounts().size());

        Account b = new Account();
        b.setNumber("8008707008");
        b.setCustomer(customerDAO.getCustomerById(2));
        b.setBalance(Float.valueOf(100000));
        b.setType(typeOfAccountDAO.getTypeOfAccountById(2));
        b.setInterestAccount(accountDAO.getAccountById(2));
        b.setDepartment(departmentDAO.getDepartmentById(2));
        b.setDate(Timestamp.valueOf("2020-03-23 12:00:20.0"));
        id = accountDAO.addAccount(b);
        accountDAO.deleteAccount(accountDAO.getAccountById(id));
        Assert.assertEquals(size , accountDAO.getAllAccounts().size());
    }

    @Test
    public void testGetAll() throws SQLException {
        Set<Integer> departmentIdSet = new HashSet<>();
        for (int i = 1; i <= 100; ++i) {
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
        Customer c = (Customer) customerDAO.getAllCustomers().get(0);
        int id = c.getId();
        int oldSize = customerDAO.getAllCustomers().size();
        customerDAO.deleteCustomerById(id);
        int newSize = customerDAO.getAllCustomers().size();

        Assert.assertNull(customerDAO.getCustomerById(id));
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
        Customer c = customerDAO.getCustomerById(2);
        int oldSize = customerDAO.getAllCustomers().size();
        c.setDateOfRegistration(Timestamp.valueOf("2019-07-11 13:00:18.0"));
        customerDAO.updateCustomer(c);
        int newSize = customerDAO.getAllCustomers().size();
        c = customerDAO.getCustomerById(2);
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

    @Test(expected = SQLException.class)
    public void testUpdateNoRequiredField() throws SQLException {
        Customer c = customerDAO.getCustomerById(2);
        c.setName(null);
        customerDAO.updateCustomer(c);
    }

    @Test
    public void testGetById() throws SQLException {
        Account a = accountDAO.getAccountById(6);

        Assert.assertEquals(a.getNumber(), "9008007006");
        Assert.assertEquals(a.getCustomer().getId(), Integer.valueOf(3));
        Assert.assertEquals(a.getType().getId(), Integer.valueOf(3));
        Assert.assertEquals(a.getDepartment().getId(), Integer.valueOf(3));
        Assert.assertEquals(a.getInterestAccount().getId(), Integer.valueOf(5));
        Assert.assertEquals(a.getBalance(), Float.valueOf(18000));
        Assert.assertEquals(a.getDate(), Timestamp.valueOf("2020-02-05 16:58:45.0"));

        a = accountDAO.getAccountById(2000000);
        Assert.assertNull(a);
    }

    @Test
    public void testCustomerWithContact() throws SQLException{
        Customer cus = new Customer();
        cus.setName("Круглов Алексей");
        cus.setDateOfRegistration(Timestamp.valueOf("2020-03-27 12:36:33.0"));
        cus.setType(CustomerType.INDIVIDUAL);
        int id_cus = customerDAO.addCustomer(cus);
        Contact con = new Contact();
        con.setCustomer(customerDAO.getCustomerById(id_cus));
        con.setName("Алексей");
        con.setSurname("Круглов");
        con.setAdress("Ул. Академика Иванова, д.3");
        con.setPhoneNumber("8 (999) 780 66 54");
        con.setEmail("krug_alex@ya.ru");
        int id_con = contactDAO.addContact(con);

        Assert.assertEquals(customerDAO.getCustomerById(id_cus).getName(), "Круглов Алексей");
        for (Contact entry : customerDAO.getCustomerById(id_cus).getContactSet()) {
            Assert.assertEquals(entry.getName(), "Алексей");
        }
    }

    @Test
    public void testDAOHelpers() throws SQLException {
        List types = DAOHelpers.ExecuteInSession(session -> session.createQuery("from TypeOfAccount").list());
        Set<Integer> ids = new HashSet<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        ids.add(6);
        ids.add(7);
        ids.add(8);
        ids.add(9);
        for (Object t : types) {
            Assert.assertTrue(ids.contains(((TypeOfAccount) t).getId()));
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
}