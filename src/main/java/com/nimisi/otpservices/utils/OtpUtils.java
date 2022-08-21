package com.nimisi.otpservices.utils;

import java.security.SecureRandom;
import java.time.LocalDateTime;

public class OtpUtils {
    public static String generateOTP(int size) {

        String numbers = "0123456789";

        SecureRandom rand = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<size;i++){
            stringBuilder.append(numbers.charAt(rand.nextInt(numbers.length())));
        }

        return stringBuilder.toString();

    }
    public static boolean expired(LocalDateTime expiryTime){
        return LocalDateTime.now().isAfter(expiryTime);
    }
}
