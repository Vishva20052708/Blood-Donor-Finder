package com.example.mediconnect.service;

import com.example.mediconnect.entity.Donor;
import com.example.mediconnect.repository.DonorRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DonorService {

    @Autowired
    DonorRepository donorRepository;



    public  Donor registerdonor(Donor donor){
        return donorRepository.save(donor);
    }

    public Optional<Donor> findByEmail(String email) {
        return donorRepository.findByEmail(email);
    }

    public Optional<Donor> findByEmailorPh(String email) {
        return donorRepository.findbyemail0rph(email);
    }

    public boolean verifylogin(String email,String password){
       return   donorRepository.login(email,password).isPresent();
    }


    public long getdonorid(String email,String password){
        Optional<Donor> optionalDonor=donorRepository.login(email,password);
        Donor donor=optionalDonor.get();
        return donor.getDonor_id();
    }

    public boolean verifylogin1(String email,String password){
        return   donorRepository.login1(email,password).isPresent();
    }

    public boolean findByPhone(String phone_number){
        return donorRepository.findbyphone1(phone_number).isPresent();
    }


    public boolean updateProfile(String full_name,String gender,String blood_group,String  email , LocalDate last_donation, boolean willing_organ, boolean donate_kidney,boolean donate_liver, String  location, boolean share_gps,float gps_lat,float gps_lng){


        Optional<Donor> donorOptional=donorRepository.findbyemail0rph(email);
        if(donorOptional.isPresent()){
            Donor donor=donorOptional.get();
            donor.setFull_name(full_name);
          //  donor.setPhone_number(phone_number);
            donor.setLast_donation(last_donation);
            donor.setWilling_organ(willing_organ);
            donor.setDonate_kidney(donate_kidney);
            donor.setDonate_liver(donate_liver);
            donor.setLocation(location);
            donor.setShare_gps(share_gps);
            donor.setGender(gender);
            donor.setBlood_group(blood_group);
            donor.setGps_lat(gps_lat);
            donor.setGps_lng(gps_lng);
            donorRepository.save(donor);
            return  true;
        }

        return false;
    }

    public Donor getDonorByEmailorphone(String email){
    //    Optional<Donor> donorOptional=donorRepository.findbyemail0rph(email);
     //   Donor donor=donorOptional.get();
        return donorRepository.findbyemail0rph(email)
                .orElseThrow(() -> new RuntimeException("Donor not found with email: " + email));
    }



}
