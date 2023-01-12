package org.example.classService;

import org.example.objectClassAndRepository.model.RegisterUser;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.repository.RegisterUserRepository;
import org.example.objectClassAndRepository.repository.TwitterUserRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckValue {


    public boolean checkStringRu(String stringToCheck) {
        char[] c = stringToCheck.toCharArray();
        if (!stringToCheck.equals(" ")) {
            return c.length >= 2;
        }
        return false;
    }

    public boolean checkStringTu(String stringToCheck) {
        char[] c = stringToCheck.toCharArray();
        if (!stringToCheck.contains(" ")) {
            return c.length >= 6;
        }
        return false;
    }

    public boolean checkStringE(String stringToCheck) {
        if (!stringToCheck.equals(" ")) {
            return stringToCheck.matches("^(.+)@(.+)$");
        }
        return false;
    }


    public boolean ruIsNotNull(RegisterUser ru) {
        return !ru.getFirstName().isEmpty() && !ru.getLastName().isEmpty() && !ru.getEmail().isEmpty();
    }

    public boolean tuIsNotNull(TwitterUser tu) {
        return !tu.getUsername().isEmpty() && !tu.getPassword().isEmpty();
    }

    public boolean validRu(RegisterUser ru) {
        return checkStringRu(ru.getFirstName()) && checkStringRu(ru.getLastName()) && checkStringE(ru.getEmail());
    }

    public boolean validTu(TwitterUser tu) {
        return checkStringTu(tu.getUsername()) && checkStringTu(tu.getPassword());
    }

    public boolean usernameExist(String username, RegisterUserRepository rUr) {
        return rUr.findUserByUsername(username) != null;
    }

    public boolean usernameExist(String username, TwitterUserRepository tUr) {
        return tUr.findById(username).isPresent();
    }

    public String getLocalDate(Timestamp ts) {
        return new SimpleDateFormat("MMM dd yyyy HH:mm:ss").format(new Date(ts.getTime()));
    }

    public String getHash(String password) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

//    public void objectNotNull(Object myParameter) {
//        if (myParameter == null) {
//            throw new IllegalArgumentException("Parameter 'myParameter' cannot be null");
//        }
//        //Do something with the parameter
//    }

}
