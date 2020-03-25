package org.db.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public class TypeOfAccount extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private TypeName type;

    private Float yield;

    private Integer interval;

    private Integer maxCredit;

    private Integer maxDebit;

    private Set<Account> accountSet = new HashSet<>();

    public TypeOfAccount() { };

    public TypeName getType() {
        return type;
    }

    public void setType(TypeName type) {
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

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }

}