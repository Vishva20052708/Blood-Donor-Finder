package com.example.mediconnect.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipient_id")
    private Long recipient_id;

    @Column(name = "organization_name")
    private String organization_name;

    @Column(name = "full_name", nullable = false)
    private String full_name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false , unique = true)
    private String password;

    @Column(name = "phone_number", nullable = false)
    private String phone_number;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "gps_lat")
    private Float gps_lat;

    @Column(name = "gps_lng")
    private Float gps_lng;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    // --- Constructor
    public Hospital() {
    }

    public Hospital(Long recipient_id, String organization_name, String full_name, String email,
                            String password, String phone_number, String address, String city, String state,
                            Float gps_lat, Float gps_lng, LocalDateTime created_at, LocalDateTime updated_at) {
        this.recipient_id = recipient_id;
        this.organization_name = organization_name;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.address = address;
        this.city = city;
        this.state = state;
        this.gps_lat = gps_lat;
        this.gps_lng = gps_lng;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // --- Getters and Setters

    public Long getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(Long recipient_id) {
        this.recipient_id = recipient_id;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public String getfull_name() {
        return full_name;
    }

    public void setfull_name(String admin_name) {
        this.full_name = admin_name;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
