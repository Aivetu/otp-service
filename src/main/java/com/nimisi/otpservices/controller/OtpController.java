package com.nimisi.otpservices.controller;

import com.nimisi.otpservices.model.CreateModel;
import com.nimisi.otpservices.service.OtpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtpController {
    @Autowired
    OtpServiceImpl otpService;


    @PostMapping("/create")
public String  createOtp(@RequestBody CreateModel createModel){
       return otpService.createNewOTP(createModel);

}

@PostMapping("/validate")
public Boolean validateOtp(@RequestBody String username, String otp)  {

        return otpService.validateNewOTP(username, otp);
}


}
