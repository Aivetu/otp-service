package com.nimisi.otpservices.service;

import com.nimisi.otpservices.model.OtpModel;
import com.nimisi.otpservices.repository.OtpRepo;
import com.nimisi.otpservices.utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.SecureRandom;
import java.time.LocalDateTime;

public class OtpServiceImpl implements OtpService {

    @Autowired
    OtpModel model;
    @Autowired
    OtpRepo repository;




    @Override
    public String createOTP(String username, int expiryTime, int size) {

       String otp = OtpUtils.generateOTP(size);

       LocalDateTime createTime = LocalDateTime.now();

       model.setExpires_at(createTime.plusMinutes(expiryTime));
       model.setCreated_at(createTime);
       model.setUsername(username);
       repository.save(model);

        return otp;
    }

    @Override
    public Boolean validateOTP(String username, int otp) throws Exception {
        if (model.getUsername() == username && model.getOtp() == otp) {
            if (OtpUtils.expired(model.getExpires_at())) {
                throw new Exception("OTP has expired!");
            }
            else {
                return true;
            }
        }
        else {
            throw new Exception("Invalid");
        }
    }

}

