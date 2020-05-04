package model;

public enum OperationType {
    CREDIT(0),
    DEBIT(1);

    private int val;

    private OperationType(int val) {
        this.val = val;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int val) {
        this.val = val;
    }
}