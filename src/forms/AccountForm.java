package forms;

import model.Account;
import model.Customer;
import model.Department;
import model.TypeOfAccount;

import javax.persistence.*;
import java.sql.Timestamp;

public class AccountForm {

    private Long accountId;
    private String number;
    private Customer customer;
    private TypeOfAccount type;
    private Account interestAccount;
    private Department department;

    public AccountForm() { };

    public AccountForm(String number, Customer customer,
                   TypeOfAccount type, Account interestAccount, Department department) {
        this.customer = customer;
        this.number = number;
        this.type = type;
        this.interestAccount = interestAccount;
        this.department = department;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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
}
