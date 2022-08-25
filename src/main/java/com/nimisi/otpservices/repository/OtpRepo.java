package com.nimisi.otpservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimisi.otpservices.model.OtpModel;

import java.time.LocalDateTime;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface OtpRepo extends JpaRepository<OtpModel,String> {
 Optional<OtpModel> findByOtp(String otp);
 Optional<OtpModel> findByUsername(String username);


}
