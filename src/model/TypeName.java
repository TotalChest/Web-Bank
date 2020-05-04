package model;

public enum TypeName {
    CORPORATE(0),
    STRICT(1),
    COMMON(2),
    LIGHT(3),
    RELIABLE(4);

    private int val;

    private TypeName(int val) {
        this.val = val;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int val) {
        this.val = val;
    }
}