package model;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "customers", schema = "public")
@TypeDef(name = "pgsql_enum", typeClass = PSQLType.class)
public class Customer {

    public enum CustomerType {
        INDIVIDUAL,
        ORGANIZATION
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "date_of_registration", nullable = false)
    private Timestamp dateOfRegistration;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    @Type(type = "pgsql_enum")
    private CustomerType type;

    public Customer() { };

    public Customer(CustomerType type, String name, Timestamp dateOfRegistration) {
        this.type = type;
        this.name = name;
        this.dateOfRegistration = dateOfRegistration;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

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

}
