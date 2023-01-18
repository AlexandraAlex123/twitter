package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;

import javax.transaction.Transactional;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional
public class ValidateFactory extends ConvertDTOFactory {

    public boolean checkStringRu(String stringToCheck) {
        char[] c = stringToCheck.toCharArray();
        if (!stringToCheck.isEmpty()) {
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

    public String getDateAndTime(Timestamp ts) {
        return new SimpleDateFormat("MMM dd yyyy HH:mm:ss").format(new Date(ts.getTime()));
    }

    public boolean isNotNull(TwitterUser tu) {
        return tu.getUsername() != null && tu.getPassword() != null;
    }

    public boolean isNotNull(RegisterUser ru) {
        return ru.getFirstName() != null && ru.getLastName() !=null && ru.getEmail() != null;
    }

    public boolean validUser(RegisterUser ru) {
        return checkStringRu(ru.getFirstName()) && checkStringRu(ru.getLastName()) && checkStringE(ru.getEmail());
    }

    public boolean validUser(TwitterUser tu) {
        return checkStringTu(tu.getUsername()) && checkStringTu(tu.getPassword());
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

}
