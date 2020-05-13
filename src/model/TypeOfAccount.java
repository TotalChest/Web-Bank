package model;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;

@Entity
@Table(name = "types_of_account", schema = "public")
@TypeDef(name = "pgsql_enum", typeClass = PSQLType.class)
public class TypeOfAccount {

    public enum AccountType {
        CORPORATE,
        STRICT,
        COMMON,
        LIGHT,
        RELIABLE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long typeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    @Type(type = "pgsql_enum")
    private AccountType type;

    @Basic
    @Column(name = "yield", nullable = false)
    private Float yield;

    @Basic
    @Column(name = "interval", nullable = false)
    private Integer interval;

    @Basic
    @Column(name = "max_credit", nullable = false)
    private Integer maxCredit;

    @Basic
    @Column(name = "max_debit", nullable = false)
    private Integer maxDebit;

    public TypeOfAccount() { };

    public TypeOfAccount(AccountType type, Float yield, Integer interval,
                            Integer maxCredit, Integer maxDebit) {
        this.type = type;
        this.yield = yield;
        this.interval = interval;
        this.maxCredit = maxCredit;
        this.maxDebit = maxDebit;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Float getYield() {
        return yield;
    }

    public void setYield(Float yield) {
        this.yield = yield;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(Integer maxCredit) {
        this.maxCredit = maxCredit;
    }

    public Integer getMaxDebit() {
        return maxDebit;
    }

    public void setMaxDebit(Integer maxDebit) {
        this.maxDebit = maxDebit;
    }

}