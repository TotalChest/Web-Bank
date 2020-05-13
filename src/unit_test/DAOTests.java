package unit_test;

import dao.*;
import model.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DAOTests {

    private SessionFactory s;
    private Transaction tx;

    private DepartmentDAO departmentDAO;
    private AccountDAO accountDAO;
    private ContactDAO contactDAO;
    private CustomerDAO customerDAO;
    private OperationDAO operationDAO;
    private TypeOfAccountDAO typeOfAccountDAO;

    public void setUp() throws Exception{
        s = new Configuration().configure().buildSessionFactory();
        tx = s.getCurrentSession().beginTransaction();
        departmentDAO = new DepartmentDAO();
        accountDAO = new AccountDAO();
        contactDAO = new ContactDAO();
        customerDAO = new CustomerDAO();
        operationDAO = new OperationDAO();
        typeOfAccountDAO = new TypeOfAccountDAO();
        departmentDAO.setSessionFactory(s);
        accountDAO.setSessionFactory(s);
        contactDAO.setSessionFactory(s);
        customerDAO.setSessionFactory(s);
        operationDAO.setSessionFactory(s);
        typeOfAccountDAO.setSessionFactory(s);
    }

    public void shutDown() throws Exception {
        tx.commit();
        s.close();
    }

    @Test
    public void testAccount() throws Exception {
        setUp();

        int size = accountDAO.getAll().size();
        Assert.assertEquals(size, 9);

        Assert.assertEquals(accountDAO.getById((long)2).getNumber(), "9008007002");

        Account a = new Account();
        a.setNumber("8008707005");
        a.setCustomer(customerDAO.getById((long)2));
        a.setBalance(Float.valueOf(100000));
        a.setType(typeOfAccountDAO.getById((long)2));
        a.setInterestAccount(accountDAO.getById((long)2));
        a.setDepartment(departmentDAO.getById((long)2));
        a.setDate(Timestamp.valueOf("2020-03-21 06:40:01.0"));
        accountDAO.save(a);
        long id = a.getAccountId();

        Assert.assertEquals(size + 1, accountDAO.getAll().size());

        Float balance = accountDAO.getById(id).getBalance();
        a.setBalance(Float.valueOf(55000));
        accountDAO.update(a);
        Assert.assertFalse(accountDAO.getById(id).getBalance() == balance);

        accountDAO.delete(a);
        Assert.assertEquals(size, accountDAO.getAll().size());

        Account b = new Account();
        b.setNumber("8008707008");
        b.setCustomer(customerDAO.getById((long)2));
        b.setBalance(Float.valueOf(100000));
        b.setType(typeOfAccountDAO.getById((long)2));
        b.setInterestAccount(accountDAO.getById((long)2));
        b.setDepartment(departmentDAO.getById((long)2));
        b.setDate(Timestamp.valueOf("2020-03-23 12:00:20.0"));
        accountDAO.save(b);
        accountDAO.delete(b);
        Assert.assertEquals(size , accountDAO.getAll().size());

        shutDown();
    }

    @Test
    public void testGetAll() throws Exception {
        setUp();
        Set<Long> departmentIdSet = new HashSet<>();
        for (int i = 1; i <= 100; ++i) {
            Department d = departmentDAO.getById((long)i);
            if (d != null) {
                departmentIdSet.add(d.getDepartmentId());
            }
        }
        Assert.assertEquals(departmentDAO.getAll().size(), departmentIdSet.size());
        for (Object d : departmentDAO.getAll()) {
            Assert.assertTrue(departmentIdSet.contains(((Department) d).getDepartmentId()));
        }
        shutDown();
    }

    @Test
    public void testAdd() throws Exception {
        setUp();
        Department d = new Department();
        d.setName("Сбербанк Технологии");
        d.setAddress("Ул. Тверская, 25 ст. 4");
        int oldSize = departmentDAO.getAll().size();
        departmentDAO.save(d);
        long id = d.getDepartmentId();
        int newSize = departmentDAO.getAll().size();
        Department d1 = departmentDAO.getById(id);

        Assert.assertEquals(d.getName(), d1.getName());
        Assert.assertEquals(d.getAddress(), d1.getAddress());
        Assert.assertEquals(newSize, oldSize + 1);
        shutDown();
    }

    @Test(expected = Exception.class)
    public void testAddNoRequiredField() throws Exception {
        setUp();
        Department d = new Department();
        departmentDAO.save(d);
        shutDown();
    }

    @Test
    public void testDelete() throws Exception {
        setUp();
        Operation o = operationDAO.getAll().get(0);
        long id = o.getOperationId();
        int oldSize = operationDAO.getAll().size();
        operationDAO.delete(o);
        int newSize = operationDAO.getAll().size();

        Assert.assertNull(operationDAO.getById(id));
        Assert.assertEquals(newSize, oldSize - 1);
        shutDown();
    }

    @Test(expected = Exception.class)
    public void testDeleteNull() throws Exception {
        setUp();
        customerDAO.delete(null);
        shutDown();
    }

    @Test(expected = Exception.class)
    public void testDeleteNonExistent() throws Exception {
        setUp();
        Customer c = new Customer();
        c.setCustomerId((long)10000000);
        customerDAO.delete(c);
        shutDown();
    }

    @Test(expected = Exception.class)
    public void testDeleteByIdNonExistent() throws Exception {
        setUp();
        typeOfAccountDAO.delete(typeOfAccountDAO.getById((long)2000000));
        shutDown();
    }

    @Test
    public void testUpdate() throws Exception {
        setUp();
        Customer c = customerDAO.getById((long)2);
        int oldSize = customerDAO.getAll().size();
        c.setDateOfRegistration(Timestamp.valueOf("2019-07-11 13:00:18.0"));
        customerDAO.update(c);
        int newSize = customerDAO.getAll().size();
        c = customerDAO.getById((long)2);
        Timestamp date = c.getDateOfRegistration();

        Assert.assertEquals(oldSize, newSize);
        Assert.assertNotNull(date);
        Assert.assertEquals(date, Timestamp.valueOf("2019-07-11 13:00:18.0"));
        shutDown();
    }

    @Test(expected = Exception.class)
    public void testUpdateNull() throws Exception {
        setUp();
        contactDAO.update(null);
        shutDown();
    }

    @Test(expected = Exception.class)
    public void testUpdateNonExistent() throws Exception {
        setUp();
        TypeOfAccount t = new TypeOfAccount();
        typeOfAccountDAO.update(t);
        shutDown();
    }

    @Test(expected = Exception.class)
    public void testUpdateNoRequiredField() throws Exception {
        setUp();
        Customer c = customerDAO.getById((long)2);
        c.setName(null);
        customerDAO.update(c);
        shutDown();
    }

    @Test
    public void testGetById() throws Exception {
        setUp();
        Account a = accountDAO.getById((long)6);

        Assert.assertEquals(a.getNumber(), "9008007006");
        Assert.assertEquals(a.getCustomer().getCustomerId(), Long.valueOf(3));
        Assert.assertEquals(a.getType().getTypeId(), Long.valueOf(3));
        Assert.assertEquals(a.getDepartment().getDepartmentId(), Long.valueOf(3));
        Assert.assertEquals(a.getInterestAccount().getAccountId(), Long.valueOf(5));
        Assert.assertEquals(a.getBalance(), Float.valueOf(18000));
        Assert.assertEquals(a.getDate(), Timestamp.valueOf("2020-02-05 16:58:45.0"));

        a = accountDAO.getById((long)2000000);
        Assert.assertNull(a);

        shutDown();
    }

    @Test
    public void testCustomerWithContact() throws Exception{
        setUp();
        Customer cus = new Customer();
        cus.setName("Круглов Алексей");
        cus.setDateOfRegistration(Timestamp.valueOf("2020-03-27 12:36:33.0"));
        cus.setType(Customer.CustomerType.ORGANIZATION);
        customerDAO.save(cus);
        long id_cus = cus.getCustomerId();
        Contact con = new Contact();
        con.setCustomer(customerDAO.getById(id_cus));
        con.setName("Алексей");
        con.setSurname("Круглов");
        con.setAddress("Ул. Академика Иванова, д.3");
        con.setPhoneNumber("8 (999) 780 66 54");
        con.setEmail("krug_alex@ya.ru");
        contactDAO.save(con);


        Assert.assertEquals(customerDAO.getById(id_cus).getName(), "Круглов Алексей");
        for (Contact entry: contactDAO.getByCustomerId(id_cus)) {
            Assert.assertEquals(entry.getName(), "Алексей");
        }

        shutDown();
    }

    @Test
    public void tectEnum() throws Exception {
        setUp();
        TypeOfAccount t = typeOfAccountDAO.getAll().get(1);
        Assert.assertEquals(t.getType(), TypeOfAccount.AccountType.LIGHT);
        shutDown();
    }
}