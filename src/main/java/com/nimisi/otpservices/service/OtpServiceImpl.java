package com.nimisi.otpservices.service;

import com.nimisi.otpservices.exceptions.OtpExceptions;
import com.nimisi.otpservices.model.CreateModel;
import com.nimisi.otpservices.model.OtpModel;
import com.nimisi.otpservices.model.ValidateModel;
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
       repository.save(model);

        return otp;
    }

    @Override
    public Boolean validateNewOTP(ValidateModel validateModel)  {
        Optional<OtpModel> username = repository.findByUsername(validateModel.getUsername());

        if(username.isPresent()){
            if (repository.findByOtp(validateModel.getOtp()).isPresent()){
                if(OtpUtils.expired(username.get().getExpires_at())){
                    username.get().setStatus("Expired");
                    repository.save(username.get());
                    throw new OtpExceptions("Otp has expired");
                }
                username.get().setUsed_at(LocalDateTime.now());
                username.get().setStatus("Used");
                repository.save(username.get());
                return true;

            }
            else throw new OtpExceptions("Incorrect Otp");
        }
        else throw new OtpExceptions("Wrong Username");





    }
}

