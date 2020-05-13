package model;

import javax.persistence.*;

@Entity
@Table(name = "contacts", schema = "public")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Basic
    @Column(name = "surname", nullable = false, length = 32)
    private String surname;

    @Basic
    @Column(name = "address", nullable = false, length = 256)
    private String address;

    @Basic
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Basic
    @Column(name = "email", nullable = false, length = 54)
    private String email;

    public Contact() { };

    public Contact(Customer customer, String name , String surname,
                     String address, String phoneNumber, String email) {
        this.customer = customer;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
    public Long getContactId() {
        return contactId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
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
