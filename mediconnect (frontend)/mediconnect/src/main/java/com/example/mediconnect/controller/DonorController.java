package com.example.mediconnect.controller;


import com.example.mediconnect.entity.Donor;
import com.example.mediconnect.service.DonorService;
import org.apache.logging.log4j.spi.ReadOnlyThreadContextMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/mediconnect")
public class DonorController {

    @Autowired
    DonorService donorService;

    @GetMapping("/signup")
    @ResponseBody
    public Map<String, String> signup() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Sign Up page..");
        return response;
    }


    @PostMapping("/signup")
    public ResponseEntity<Map<String,String>>  signup(@RequestBody Donor donor){
        Map<String, String> response = new HashMap<>();

        if (donorService.findByPhone(donor.getPhone_number()) && donorService.findByEmail(donor.getEmail()).isPresent() ) {
            response.put("message", "Phone Number and Email already exists");
            return ResponseEntity.ok(response);
        }
        else if(donorService.findByEmail(donor.getEmail()).isPresent() ){
            response.put("message", "Email already exists");
            return ResponseEntity.ok(response);
        } else if (donorService.findByPhone(donor.getPhone_number())) {
            response.put("message", "Phone Number already exists");
            return ResponseEntity.ok(response);
        }


        donorService.registerdonor(donor);
        response.put("message", "User registered successfully");
        return ResponseEntity.ok(response);

    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody Donor donor){
        Map<String,String> response=new HashMap<>();
        boolean bn=donorService.verifylogin(donor.getEmail(),donor.getPassword());
        if(bn){
          Long donor_id =  donorService.getdonorid(donor.getEmail(),donor.getPassword());
          System.out.println(donor_id);
          String s="Login Succesfull"+donor_id;
            response.put("message", s);
            return ResponseEntity.ok(response);
         }
        else if(donorService.verifylogin1(donor.getEmail(),donor.getPassword())){
            response.put("message", "Login Succesfull1");
            return ResponseEntity.ok(response);
        }
        response.put("message", "Login Failed");
        return ResponseEntity.ok(response);
    }


    @PutMapping("/updateDonor")
    public ResponseEntity<?> updateDonorProfile(
            @RequestParam("full_name")String full_name,
            @RequestParam("gender")String gender,
            @RequestParam("blood_group")String blood_group,
            @RequestParam("email")String email,
            @RequestParam("last_donation") LocalDate last_donation,
            @RequestParam("willing_organ")boolean willing_organ,
            @RequestParam("donate_kidney")boolean donate_kidney,
            @RequestParam("donate_liver")boolean donate_liver,
            @RequestParam("location")String location,
            @RequestParam("share_gps")boolean share_gps,
            @RequestParam("gps_lat")Float gps_lat,
            @RequestParam("gps_lng")Float gps_lng
            ){

        try {
            // Update user profile with optional photo
            boolean success = donorService.updateProfile(full_name,gender,blood_group,email,last_donation,willing_organ,donate_kidney,donate_liver,location,share_gps,gps_lat,gps_lng);

            if (success) {
                // Fetch updated user details
                Optional<Donor> updatedUser = donorService.findByEmailorPh(email);

                if (updatedUser.isPresent()) {
                    return ResponseEntity.ok(Map.of(
                            "message", "Profile updated successfully"
                    ));
                } else {
                    return ResponseEntity.status(404).body(Map.of("error", "User not found after update."));
                }
            } else {
                return ResponseEntity.ok(Map.of("message", "User not found."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Failed to update profile: " + e.getMessage()));
        }

    }


    @GetMapping("/getDonorByEmail")
    public ResponseEntity<Donor> getDonor(@RequestParam String email){
        Donor donor=donorService.getDonorByEmailorphone(email);
                return ResponseEntity.ok(donor);
    }




}
