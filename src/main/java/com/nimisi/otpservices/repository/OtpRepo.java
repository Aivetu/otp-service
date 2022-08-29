package com.nimisi.otpservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimisi.otpservices.model.OtpModel;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface OtpRepo extends JpaRepository<OtpModel,String> {
 Optional<OtpModel> findByUsernameAndOtp(String username,String otp);



}
