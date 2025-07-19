package com.example.mediconnect.entity;

import jakarta.persistence.*;
        import java.time.LocalDateTime;

@Entity
@Table(name = "matchedreq")
public class MatchedReq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long match_id;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    @ManyToOne
    @JoinColumn(name = "donor_id", nullable = false)
    private Donor donor;

    @Column(name = "status")
    private String status; // pending, accepted, rejected, completed

    @Column(name = "matched_at")
    private LocalDateTime matched_at;

    // Constructors, Getters, and Setters

    public Long getMatch_id() {
        return match_id;
    }

    public void setMatch_id(Long match_id) {
        this.match_id = match_id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getMatched_at() {
        return matched_at;
    }

    public void setMatched_at(LocalDateTime matched_at) {
        this.matched_at = matched_at;
    }


    // Include constructor and all getters/setters as needed


    public MatchedReq(Long match_id, Request request, Donor donor, String status, LocalDateTime matched_at) {
        this.match_id = match_id;
        this.request = request;
        this.donor = donor;
        this.status = status;
        this.matched_at = matched_at;
    }
}
