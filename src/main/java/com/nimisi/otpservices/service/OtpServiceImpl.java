package com.nimisi.otpservices.service;

import com.nimisi.otpservices.enums.OtpStatus;
import com.nimisi.otpservices.exceptions.OtpExceptions;
import com.nimisi.otpservices.model.CreateModel;
import com.nimisi.otpservices.model.OtpModel;
import com.nimisi.otpservices.repository.OtpRepo;
import com.nimisi.otpservices.utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OtpServiceImpl implements OtpService {


    @Autowired
    OtpRepo repository;






    @Override
    public String createNewOTP(CreateModel createModel) {

       String otp = OtpUtils.generateOTP(createModel.getSize());

       LocalDateTime createTime = LocalDateTime.now();
       OtpModel model = new OtpModel();



       model.setExpires_at(createTime.plusMinutes(createModel.getExpiryTime()));
       model.setCreated_at(createTime);
       model.setUsername(createModel.getUsername());
       model.setOtp(otp);
       model.setStatus(OtpStatus.ACTIVE);
       repository.save(model);

        return otp;
    }

    @Override
    public Boolean validateNewOTP(String username,String otp)  {
        Optional<OtpModel> user = repository.findByUsernameAndOtp(username, otp);

        if(user.isPresent()){
                if(OtpUtils.expired(user.get().getExpires_at())){
                    user.get().setStatus(OtpStatus.EXPIRED);
                    repository.save(user.get());
                    throw new OtpExceptions("Otp has expired");
                }
                user.get().setUsed_at(LocalDateTime.now());
                user.get().setStatus(OtpStatus.USED);
                repository.save(user.get());
                return true;


        }
        else throw new OtpExceptions("Incorrect OTP");





    }
}

