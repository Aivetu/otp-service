package com.nimisi.otpservices.service;


import java.time.LocalDateTime;

@org.springframework.stereotype.Service
interface OtpService {
    public int generateOTP(String username, LocalDateTime expiryTime, int size);

    public Boolean validateOTP(String username,int otp);


}