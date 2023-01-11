package org.example.classService.service.classDtO;

public class RegisterUserDtO implements Comparable<RegisterUserDtO> {

    String firstName;
    String lastName;
    String username;


    public RegisterUserDtO(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                ", username='" + username + '\'' +
                '}';
    }
}
