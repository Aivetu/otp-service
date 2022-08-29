package com.nimisi.otpservices.service;


import com.nimisi.otpservices.model.CreateModel;


interface OtpService {
    String createNewOTP(CreateModel createModel);

    Boolean validateNewOTP(String username,String otp) throws Exception;


}