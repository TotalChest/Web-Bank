package forms;

import javax.persistence.*;

public class DepartmentForm {

    private String name;
    private String address;

    public DepartmentForm() { };

    public DepartmentForm(String name, String address) {
        this.address = address;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
