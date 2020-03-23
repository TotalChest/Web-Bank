package org.db.model;

import java.util.HashSet;
import java.util.Set;
import java.sql.Date;


public class Account extends BaseEntity {

    private String number;

    private Cuctomer customer;

    private Float balance;

    private TypeOfAccount type;

    private Accounts interestAccount;

    private Department department;

    private Date date;

    private Set<Operation> operationSet = new HashSet<>();

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

    public Account getDepertment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Set<Operation> getOperationSet() {
        return operationSet;
    }

    public void setOperationSet(Set<Operation> operationSet) {
        this.operationSet = operationSet;
    }
}
