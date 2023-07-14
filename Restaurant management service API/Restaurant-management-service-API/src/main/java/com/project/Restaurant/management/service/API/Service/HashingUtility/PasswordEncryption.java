package com.project.Restaurant.management.service.API.Service.HashingUtility;

import jakarta.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryption {
    public static String encryptionpassword(String userpassword) throws NoSuchAlgorithmException{
        MessageDigest md5=MessageDigest.getInstance("MD5");
        md5.update(userpassword.getBytes());
        byte[] digested=md5.digest();
        return DatatypeConverter.printHexBinary(digested);
    }

}
