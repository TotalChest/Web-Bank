package spring;

import dao.*;
import model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Application {

    private final DAOFactory factory;

    private static Application instance;

    public Application() {
        factory = DAOFactory.getInstance();
    }

    public static synchronized Application getInstance(){
        if (instance == null){
            instance = new Application();
        }
        return instance;
    }

    public ResponseEntity addDepartment(String name, String address) {
        Department department = new Department();
        department.setName(name);
        department.setAdress(address);

        try {
            //factory.getDepartmentDAO().addDepartment(department);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Company added successfully", HttpStatus.OK);
    }

    public ResponseEntity addCustomer(String type, String name,
                                      String surname, String address,
                                      String phone, String mail) {
        int id;
        Customer customer = new Customer();
        Contact contact = new Contact();
        customer.setType(CustomerType.INDIVIDUAL);
        customer.setName(name);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        customer.setDateOfRegistration(timestamp);
        try {
            id = factory.getCustomerDAO().addCustomer(customer);
            contact.setCustomer(factory.getCustomerDAO().getCustomerById(id));
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        contact.setName(name);
        contact.setSurname(surname);
        contact.setAdress(address);
        contact.setPhoneNumber(phone);
        contact.setEmail(mail);
        try {
            factory.getContactDAO().addContact(contact);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Company added successfully", HttpStatus.OK);
    }
}