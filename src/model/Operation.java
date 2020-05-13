package model;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "operations", schema = "public")
@TypeDef(name = "pgsql_enum", typeClass = PSQLType.class)
public class Operation {

    public enum OperationType {
        CREDIT,
        DEBIT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    private Long operationId;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = true)
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation", nullable = false)
    @Type(type = "pgsql_enum")
    private OperationType operation;

    @Basic
    @Column(name = "amount", nullable = false)
    private Float amount;

    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;

    public Operation() { }

    public Operation(Account account, OperationType operation, Float amount,
                         Timestamp date) {
        this.account = account;
        this.operation = operation;
        this.amount = amount;
        this.date = date;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Long getOperationId() {
        return operationId;
    }

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
