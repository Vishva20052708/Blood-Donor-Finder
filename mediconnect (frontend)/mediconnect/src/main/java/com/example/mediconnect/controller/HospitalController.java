package com.example.mediconnect.controller;

import com.example.mediconnect.entity.Donor;
import com.example.mediconnect.entity.Hospital;
import com.example.mediconnect.entity.LoginRequest;
import com.example.mediconnect.service.DonorService;
import com.example.mediconnect.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/mediconnect")
public class HospitalController {



    @Autowired
    HospitalService hospitalService;

    @GetMapping("/hossignup")
    @ResponseBody
    public Map<String, String> signup() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Sign Up page..");
        return response;
    }


    @PostMapping("/hossignup")
    public ResponseEntity<Map<String,String>> signup(@RequestBody Hospital hospital){
        Map<String, String> response = new HashMap<>();

        if (hospitalService.findByPhone(hospital.getPhone_number()) && hospitalService.findByEmail(hospital.getEmail()).isPresent() ) {
            response.put("message", "Phone Number and Email already exists");
            return ResponseEntity.ok(response);
        }
        else if(hospitalService.findByEmail(hospital.getEmail()).isPresent() ){
            response.put("message", "Email already exists");
            return ResponseEntity.ok(response);
        } else if (hospitalService.findByPhone(hospital.getPhone_number())) {
            response.put("message", "Phone Number already exists");
            return ResponseEntity.ok(response);
        }


        hospitalService.registerdonor(hospital);
        response.put("message", "User registered successfully");
        return ResponseEntity.ok(response);

    }

    @PostMapping("/hoslogin")
    public ResponseEntity<Map<String,String>> login(@RequestBody Donor donor){
        Map<String,String> response=new HashMap<>();
        boolean bn=hospitalService.verifylogin(donor.getEmail(),donor.getPassword());
        if(bn){
            response.put("message", "Login Succesfull");
            return ResponseEntity.ok(response);
        }
        response.put("message", "Login Failed");
        return ResponseEntity.ok(response);

    }

    @PutMapping("/updatehospital")
    public ResponseEntity<?> updateDonorProfile(
            @RequestParam("organization_name")String organization_name,
            @RequestParam("full_name")String full_name,
            @RequestParam("email")String email,
            @RequestParam("address")String address,
            @RequestParam("city")String city,
            @RequestParam("state")String state,
            @RequestParam("gps_lat")Float gps_lat,
            @RequestParam("gps_lng")Float gps_lng
            ){

        try {
            // Update user profile with optional photo
            boolean success = hospitalService.updatehospital(organization_name,full_name,email,address,city,state,gps_lat,gps_lng);

            if (success) {
                // Fetch updated user details
                Optional<Hospital> updatedUser = hospitalService.findByEmailorPh(email);

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



    @GetMapping("/getHospitalByEmail")
    public ResponseEntity<Hospital> getDonor(@RequestParam String email){
        Hospital hospital=hospitalService.gethosByEmailorphone(email);
        return ResponseEntity.ok(hospital);
    }



    @PostMapping("/recipient_id")
    public ResponseEntity<Map<String,Long>> loginRecipient(@RequestBody LoginRequest request) {

        Map<String , Long> response=new HashMap<>();

        System.out.println(request.getEmailOrPhone()+""+request.getPassword());
        Long recipientId = hospitalService.getRecipientIdByLogin(request.getEmailOrPhone(), request.getPassword());

            response.put("message",recipientId);


        return ResponseEntity.ok(response);
    }




}
