package model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;


public class Customer extends BaseEntity {

    private String name;

    private Timestamp dateOfRegistration;

    @Enumerated(EnumType.STRING)
    private CustomerType type;

    private Set<Account> accountSet = new HashSet<>();

    private Set<Contact> contactSet = new HashSet<>();

    public Customer() { };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Timestamp dateOfRegistration)    {
        this.dateOfRegistration = dateOfRegistration;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }

    public Set<Contact> getContactSet() {
        return contactSet;
    }

    public void setContactSet(Set<Contact> contactSet) {
        this.contactSet = contactSet;
    }

}
