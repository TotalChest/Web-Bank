package org.db.model;

public enum CustomerType {
    INDIVIDUAL(0),
    ORGANIZATION(1);

    private int val;

    private CustomerType(int val) {
        this.val = val;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int val) {
        this.val = val;
    }
}
