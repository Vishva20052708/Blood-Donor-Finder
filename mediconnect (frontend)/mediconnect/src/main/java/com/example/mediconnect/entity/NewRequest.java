package com.example.mediconnect.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "NewRequest")
public class NewRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "recipient_id", nullable = false)
    private Long recipientId;

    @Column(name = "donor_id")
    private Long donorId;  // optional

    @Column(name = "request_type", nullable = false)
    private String requestType; // "blood" or "organ"

    @Column(name = "blood_group")
    private String bloodGroup; // if blood

    @Column(name = "organ_type")
    private String organType; // if organ

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "urgency")
    private String urgency;

    @Column(name = "status")
    private String status; // open, completed

    @Column(name = "required_date")
    private LocalDate requiredDate;

    @Column(name = "posted_at")
    private LocalDateTime postedAt;

    @Column(name = "fulfilled_at")
    private LocalDateTime fulfilledAt;

    // Constructors


    public NewRequest(Long requestId, Long recipientId, Long donorId, String requestType, String bloodGroup, String organType, Integer quantity, String urgency, String status, LocalDate requiredDate, LocalDateTime postedAt, LocalDateTime fulfilledAt) {
        this.requestId = requestId;
        this.recipientId = recipientId;
        this.donorId = donorId;
        this.requestType = requestType;
        this.bloodGroup = bloodGroup;
        this.organType = organType;
        this.quantity = quantity;
        this.urgency = urgency;
        this.status = status;
        this.requiredDate = requiredDate;
        this.postedAt = postedAt;
        this.fulfilledAt = fulfilledAt;
    }

    // Getters and Setters
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getOrganType() {
        return organType;
    }

    public void setOrganType(String organType) {
        this.organType = organType;
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

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public LocalDateTime getFulfilledAt() {
        return fulfilledAt;
    }

    public void setFulfilledAt(LocalDateTime fulfilledAt) {
        this.fulfilledAt = fulfilledAt;
    }
}
