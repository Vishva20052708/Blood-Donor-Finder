package com.example.mediconnect.service;

import com.example.mediconnect.entity.DonorMatchDTO;
import com.example.mediconnect.entity.NewRequest;
import com.example.mediconnect.entity.Request;
import com.example.mediconnect.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public NewRequest createRequest(NewRequest newRequest) {
        newRequest.setPostedAt(LocalDateTime.now());
        newRequest.setStatus("open"); // default status
        return requestRepository.save(newRequest);
    }

    public List<DonorMatchDTO> getrequest1(Long donor_id){
        return requestRepository.getrequest2(donor_id);
    }
}

