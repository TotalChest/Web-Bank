package model;

import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;


public class Account extends BaseEntity {

    private String number;

    private Customer customer;

    private Float balance;

    private TypeOfAccount type;

    private Account interestAccount;

    private Department department;

    private Timestamp date;

    private Set<Operation> operationSet = new HashSet<>();

    private Set<Account> accountSet = new HashSet<>();

    public Account() { };

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

    public Set<Operation> getOperationSet() {
        return operationSet;
    }

    public void setOperationSet(Set<Operation> operationSet) {
        this.operationSet = operationSet;
    }

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }
}
