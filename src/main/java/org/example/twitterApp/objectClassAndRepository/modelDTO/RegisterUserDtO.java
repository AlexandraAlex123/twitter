package org.example.twitterApp.objectClassAndRepository.modelDTO;

public class RegisterUserDtO implements Comparable<RegisterUserDtO> {

    String firstName;
    String lastName;
    String createDate;
    String account;

    public RegisterUserDtO(String firstName, String lastName, String createDate, String account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.createDate = createDate;
        this.account = account;
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
                ", createDate='" + createDate + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
