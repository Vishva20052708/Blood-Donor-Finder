package com.example.mediconnect.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donor")
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donor_id")
    private Long donor_id;

    @Column(name = "full_name", nullable = false)
    private String full_name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "blood_group")
    private String blood_group;

    @Column(name = "last_donation")
    private LocalDate last_donation;

    @Column(name = "willing_organ")
    private Boolean willing_organ;

    @Column(name = "donate_kidney")
    private Boolean donate_kidney;

    @Column(name = "donate_liver")
    private Boolean donate_liver;

    @Column(name = "location")
    private String location;

    @Column(name = "share_gps")
    private Boolean share_gps;

    @Column(name = "gps_lat")
    private Float gps_lat;

    @Column(name = "gps_lng")
    private Float gps_lng;

    // --- Constructor (You can keep/add more if needed)
    public Donor() {
    }

    public Donor(Long donor_id, String full_name, String email, String password, String gender, String phone_number,
                 String blood_group, LocalDate last_donation, Boolean willing_organ, Boolean donate_kidney,
                 Boolean donate_liver, String location, Boolean share_gps, Float gps_lat, Float gps_lng) {
        this.donor_id = donor_id;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phone_number = phone_number;
        this.blood_group = blood_group;
        this.last_donation = last_donation;
        this.willing_organ = willing_organ;
        this.donate_kidney = donate_kidney;
        this.donate_liver = donate_liver;
        this.location = location;
        this.share_gps = share_gps;
        this.gps_lat = gps_lat;
        this.gps_lng = gps_lng;
    }

    // --- Getters and Setters
    public Long getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(Long donor_id) {
        this.donor_id = donor_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public LocalDate getLast_donation() {
        return last_donation;
    }

    public void setLast_donation(LocalDate last_donation) {
        this.last_donation = last_donation;
    }

    public Boolean getWilling_organ() {
        return willing_organ;
    }

    public void setWilling_organ(Boolean willing_organ) {
        this.willing_organ = willing_organ;
    }

    public Boolean getDonate_kidney() {
        return donate_kidney;
    }

    public void setDonate_kidney(Boolean donate_kidney) {
        this.donate_kidney = donate_kidney;
    }

    public Boolean getDonate_liver() {
        return donate_liver;
    }

    public void setDonate_liver(Boolean donate_liver) {
        this.donate_liver = donate_liver;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getShare_gps() {
        return share_gps;
    }

    public void setShare_gps(Boolean share_gps) {
        this.share_gps = share_gps;
    }

    public Float getGps_lat() {
        return gps_lat;
    }

    public void setGps_lat(Float gps_lat) {
        this.gps_lat = gps_lat;
    }

    public Float getGps_lng() {
        return gps_lng;
    }

    public void setGps_lng(Float gps_lng) {
        this.gps_lng = gps_lng;
    }
}
