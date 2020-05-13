package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "accounts", schema = "public")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Basic
    @Column(name = "number", nullable = false, length = 10)
    private String number;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;

    @Basic
    @Column(name = "balance", nullable = false)
    private Float balance;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = true)
    private TypeOfAccount type;

    @ManyToOne
    @JoinColumn(name = "interest_account", nullable = true)
    private Account interestAccount;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = true)
    private Department department;

    @Basic
    @Column(name = "date_of_start", nullable = false)
    private Timestamp date;

    public Account() { };

    public Account(String number, Customer customer, Float balance,
                   TypeOfAccount type, Account interestAccount, Department department,
                    Timestamp date) {
        this.customer = customer;
        this.number = number;
        this.balance = balance;
        this.type = type;
        this.interestAccount = interestAccount;
        this.department = department;
        this.date = date;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public TypeOfAccount getType() {
        return type;
    }

    public void setType(TypeOfAccount type) {
        this.type = type;
    }

    public Account getInterestAccount() {
        return interestAccount;
    }

    public void setInterestAccount(Account interestAccount) {
        this.interestAccount = interestAccount;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date)
    {
        this.date = date;
    }
}
