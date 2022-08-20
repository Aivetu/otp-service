package com.nimisi.otpservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimisi.otpservices.model.OtpModel;

@org.springframework.stereotype.Repository
public interface OtpRepo extends JpaRepository<OtpModel,Integer> {

}
