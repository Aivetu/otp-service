package com.nimisi.otpservices.service;

import com.nimisi.otpservices.model.OtpModel;
import com.nimisi.otpservices.repository.OtpRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.SecureRandom;
import java.time.LocalDateTime;

public class OtpServiceImpl implements OtpService {

    @Autowired
    OtpModel model;
    @Autowired
    OtpRepo repository;

    @Override
    public int generateOTP(String username, LocalDateTime expiryTime, int sizeofotp) {
        SecureRandom rand = new SecureRandom();
        int otp = rand.nextInt();

        return otp;

    }

    @Override
    public Boolean validateOTP(String username, int otp) {

        return null;
    }
}
