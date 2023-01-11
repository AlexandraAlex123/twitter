package org.example.classService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
