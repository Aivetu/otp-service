package com.nimisi.otpservices.service;


import com.nimisi.otpservices.model.CreateModel;
import com.nimisi.otpservices.model.ValidateModel;


interface OtpService {
    public String createNewOTP(CreateModel createModel);

    public Boolean validateNewOTP(ValidateModel validateModel) throws Exception;


}