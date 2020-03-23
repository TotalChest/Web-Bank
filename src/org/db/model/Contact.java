package org.db.model;


public class Contacts extends BaseEntity {

    private Customer customer;

    private String name;

    private String surname;

    private String adress;

    private String phoneNumber;

    private String email;

    public Contacts() { };

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*

    public boolean matchesWorker(Worker w) {
        boolean positionReq = prevPositionReq == null;
        boolean companyReq = prevCompanyReq == null;
        boolean workerMinSalaryReq = w.getMinSalaryReq() == null;
        boolean workerPositionReq = w.getPositionReq() == null;
        for (JobHistory history : w.getHistoryEntries()) {
            if (!positionReq && history.getPosition().toLowerCase().equals(prevPositionReq.toLowerCase())) {
                positionReq = true;
            }
            if (!companyReq && history.getCompany().getId().equals(prevCompanyReq.getId())) {
                companyReq = true;
            }
            if (companyReq && positionReq) {
                break;
            }
        }
        System.out.println();
        return w.getLookingForJob()
                && (workerPositionReq || (w.getPositionReq().toLowerCase().equals(position.toLowerCase())))
                && (workerMinSalaryReq || minSalary == null || minSalary <= w.getMinSalaryReq())
                && (workerMinSalaryReq || maxSalary == null || maxSalary >= w.getMinSalaryReq())
                && (minEducationLevel.getValue() <= w.getEducationLevel().getValue())
                && positionReq && companyReq;
    }

     */
}
