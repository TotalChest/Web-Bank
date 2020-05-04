package model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;


public class Operation extends BaseEntity {

    private Account account;

    @Enumerated(EnumType.STRING)
    private OperationType operation;

    private Float amount;

    private Timestamp date;

    public Operation() { }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date)
    {
        this.date = date;
    }
}
