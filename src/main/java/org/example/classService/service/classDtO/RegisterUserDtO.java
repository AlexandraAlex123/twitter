package org.example.classService.service.classDtO;

public class RegisterUserDtO implements Comparable<RegisterUserDtO> {

    String firstName;
    String lastName;
    String account;
    String createDate;


    public RegisterUserDtO(String firstName, String lastName, String account, String createDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.createDate = createDate;
    }

    public RegisterUserDtO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int compareTo(RegisterUserDtO o) {
        int i = this.firstName.compareTo(o.getFirstName());
        if (i == 0) {
            i = this.lastName.compareTo(o.getLastName());
            if (i == 0) {
                return i;
            }
        }
        return i;
    }

    @Override
    public String toString() {
        return "RegisterUserDtO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account='" + account + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
