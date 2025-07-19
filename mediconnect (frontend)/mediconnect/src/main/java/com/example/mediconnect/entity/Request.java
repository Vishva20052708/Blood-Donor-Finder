package com.example.mediconnect.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long request_id;

    @ManyToOne
    @JoinColumn(name = "recipient_id", nullable = false)
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Donor donor; // Optional – if matched

    @Column(name = "request_type", nullable = false)
    private String request_type; // "blood" or "organ"

    @Column(name = "blood_group")
    private String blood_group; // required if type = blood

    @Column(name = "organ_type")
    private String organ_type; // required if type = organ

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "urgency")
    private String urgency; // High, Low

    @Column(name = "status")
    private String status; // open,  completed,

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "posted_at")
    private LocalDateTime posted_at;

    @Column(name = "fulfilled_at")
    private LocalDateTime fulfilled_at;

    // Constructors, Getters, and Setters


    public Long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public String getRequest_type() {
        return request_type;
    }

    public void setRequest_type(String request_type) {
        this.request_type = request_type;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getOrgan_type() {
        return organ_type;
    }

    public void setOrgan_type(String organ_type) {
        this.organ_type = organ_type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public LocalDateTime getPosted_at() {
        return posted_at;
    }

    public void setPosted_at(LocalDateTime posted_at) {
        this.posted_at = posted_at;
    }

    public LocalDateTime getFulfilled_at() {
        return fulfilled_at;
    }

    public void setFulfilled_at(LocalDateTime fulfilled_at) {
        this.fulfilled_at = fulfilled_at;
    }

    public Request() {}

    // Include constructor and all getters/setters as needed


    public Request(Long request_id, Hospital hospital, Donor donor, String request_type, String blood_group, String organ_type, Integer quantity, String urgency, String status, String city, String state, LocalDateTime posted_at, LocalDateTime fulfilled_at) {
        this.request_id = request_id;
        this.hospital = hospital;
        this.donor = donor;
        this.request_type = request_type;
        this.blood_group = blood_group;
        this.organ_type = organ_type;
        this.quantity = quantity;
        this.urgency = urgency;
        this.status = status;
        this.city = city;
        this.state = state;
        this.posted_at = posted_at;
        this.fulfilled_at = fulfilled_at;
    }
}
