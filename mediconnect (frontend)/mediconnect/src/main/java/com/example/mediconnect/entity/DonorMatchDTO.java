package com.example.mediconnect.entity;



public class DonorMatchDTO {
    private String hospitalName;
    private String requestedType;
    private int quantity;
    private String urgency;
    private String fullAddress;
    private String distanceKm; // either distance in km or "GPS not shared"

    // Getters and Setters

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getRequestedType() {
        return requestedType;
    }

    public void setRequestedType(String requestedType) {
        this.requestedType = requestedType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(String distanceKm) {
        this.distanceKm = distanceKm;
    }

    public DonorMatchDTO(String hospitalName, String requestedType, int quantity, String urgency, String fullAddress, String distanceKm) {
        this.hospitalName = hospitalName;
        this.requestedType = requestedType;
        this.quantity = quantity;
        this.urgency = urgency;
        this.fullAddress = fullAddress;
        this.distanceKm = distanceKm;
    }
}
