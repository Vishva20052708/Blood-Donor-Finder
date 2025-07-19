package com.example.mediconnect.service;

import com.example.mediconnect.entity.Donor;
import com.example.mediconnect.entity.Hospital;
import com.example.mediconnect.repository.DonorRepository;
import com.example.mediconnect.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;



    public Hospital registerdonor(Hospital hospital){
        return hospitalRepository.save(hospital);
    }

    public Optional<Hospital> findByEmail(String email) {
        return hospitalRepository.findByEmail(email);
    }

    public boolean verifylogin(String email,String password){
        return   hospitalRepository.login(email,password).isPresent();
    }

    public boolean findByPhone(String phone_number){
        return hospitalRepository.findbyphone1(phone_number).isPresent();
    }


    public boolean updatehospital(String organization_name,String full_name, String email, String address, String  city , String  state,float gps_lat,float gps_lng){


        Optional<Hospital> hospitalOptional=hospitalRepository.findbyemail0rph(email);
        if(hospitalOptional.isPresent()){
            Hospital hospital=hospitalOptional.get();
            hospital.setOrganization_name(organization_name);
            hospital.setfull_name(full_name);;
            hospital.setAddress(address);
            hospital.setCity(city);
            hospital.setState(state);
            hospital.setGps_lat(gps_lat);
            hospital.setGps_lng(gps_lng);
            hospitalRepository.save(hospital);
            return  true;
        }

        return false;
    }

    public Optional<Hospital> findByEmailorPh(String email) {
        return hospitalRepository.findbyemail0rph(email);
    }


    public Hospital gethosByEmailorphone(String email){
        return hospitalRepository.findbyemail0rph(email)
                .orElseThrow(() -> new RuntimeException("Hospital not found with email: " + email));
    }

    public Long getRecipientIdByLogin(String emailOrPhone, String password) {

        Optional<Hospital> hospitalOptional=hospitalRepository.login(emailOrPhone, password);
        if(hospitalOptional.isPresent()){
            Hospital hospital=hospitalOptional.get();
            return hospital.getRecipient_id();
        }
        return -1L;


          //return hospitalRepository.findByEmailOrPhoneAndPassword(emailOrPhone, password)
        //       .map(Hospital::getRecipient_id)
             //   .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }


}
