package com.example.mediconnect.repository;

import com.example.mediconnect.entity.Donor;
import com.example.mediconnect.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static javax.swing.text.html.HTML.Tag.SELECT;
import static org.hibernate.grammars.hql.HqlParser.FROM;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {

    Optional<Donor> findByEmail(String email);
    // Optional<Donor> findByPhone_number(String phone_number);

    @Query(value = "SELECT * FROM Donor WHERE (email = :email OR phone_number= :email) AND password = :password", nativeQuery = true)
    Optional<Donor> login(@Param("email") String email, @Param("password") String password);


    @Query(value = "SELECT * FROM Hospital WHERE (email = :email OR phone_number= :email) AND password = :password", nativeQuery = true)
    Optional<Hospital> login1(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT * FROM Donor WHERE phone_number = :phone_number " , nativeQuery = true)
    Optional<Donor> findbyphone1(@Param("phone_number") String phone_number );

    @Query(value = "SELECT * FROM Donor WHERE(email = :email OR phone_number= :email) " , nativeQuery = true)
    Optional<Donor> findbyemail0rph(@Param("email") String email );



}

