package com.example.mediconnect.repository;

import com.example.mediconnect.entity.Donor;
import com.example.mediconnect.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    Optional<Hospital> findByEmail(String email);

    @Query(value = "SELECT * FROM Hospital WHERE (email = :email OR phone_number= :email) AND password = :password", nativeQuery = true)
    Optional<Hospital> login(@Param("email") String email, @Param("password") String password);


    @Query(value = "SELECT * FROM Hospital WHERE phone_number = :phone_number " , nativeQuery = true)
    Optional<Hospital> findbyphone1(@Param("phone_number") String phone_number );


    @Query(value = "SELECT * FROM Hospital WHERE(email = :email OR phone_number= :email) " , nativeQuery = true)
    Optional<Hospital> findbyemail0rph(@Param("email") String email );


    @Query("SELECT r FROM Hospital r WHERE (r.email = :input OR r.phone_number = :input) AND r.password = :password")
    Optional<Hospital> findByEmailOrPhoneAndPassword(@Param("input") String emailOrPhone, @Param("password") String password);


}
