package forms;

import model.Customer;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

public class CustomerForm {

    private Long customerId;
    private String name;
    private Customer.CustomerType type;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;

    public CustomerForm() { };

    public CustomerForm(Customer.CustomerType type, String name, Timestamp dateOfRegistration , String surname,
                        String address, String phoneNumber, String email) {
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer.CustomerType getType() {
        return type;
    }

    public void setType(Customer.CustomerType type) {
        this.type = type;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
