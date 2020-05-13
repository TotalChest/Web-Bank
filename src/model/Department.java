package model;

import javax.persistence.*;

@Entity
@Table(name = "departments", schema = "public")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Basic
    @Column(name = "address", nullable = false, length = 256)
    private String address;

    public Department() { };

    public Department(String name, String address) {
        this.address = address;
        this.name = name;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() {
        return departmentId;
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