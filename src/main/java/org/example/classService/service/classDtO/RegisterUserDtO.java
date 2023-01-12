package org.example.classService.service.classDtO;

import java.sql.Date;
import java.time.DateTimeException;

public class RegisterUserDtO implements Comparable<RegisterUserDtO> {

    String firstName;
    String lastName;
    String username;
    String date;


    public RegisterUserDtO(String firstName, String lastName, String username, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
                ", date='" + date + '\'' +
                '}';
    }
}
