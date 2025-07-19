package com.example.mediconnect.controller;

import com.example.mediconnect.entity.DonorMatchDTO;
import com.example.mediconnect.entity.NewRequest;
import com.example.mediconnect.entity.Request;
import com.example.mediconnect.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mediconnect")
public class RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/hosrequest")
    public ResponseEntity<Map<String,String>> createRequest(@RequestBody NewRequest newRequest) {
        Map<String,String> response=new HashMap<>();
        NewRequest savedRequest = requestService.createRequest(newRequest);
        response.put("message","Request Sent Successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getrequest/{donor_id}")
    public List<DonorMatchDTO>   getrequest(@PathVariable Long donor_id){
        return requestService.getrequest1(donor_id);
    }
}