package com.nimisi.otpservices.service;


import java.time.LocalDateTime;

@org.springframework.stereotype.Service
interface OtpService {
    public String createOTP(String username, int expiryTime, int size);

    public Boolean validateOTP(String username,int otp) throws Exception;


}