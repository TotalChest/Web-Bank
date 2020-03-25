package org.db.model;

import java.util.HashSet;
import java.util.Set;

public class Department extends BaseEntity {

    private String name;

    private String adress;

    private Set<Account> accountSet = new HashSet<>();

    public Department() { };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }

}