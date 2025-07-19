package com.example.mediconnect.repository;

import com.example.mediconnect.entity.DonorMatchDTO;
import com.example.mediconnect.entity.NewRequest;
import com.example.mediconnect.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<NewRequest, Long> {

    @Query(value = """
        SELECT 
            h.organization_name AS hospitalName,
            COALESCE(nr.organ_type, nr.blood_group) AS requestedType,
            nr.quantity,
            nr.urgency,
            CONCAT_WS(', ', h.address, h.city, h.state) AS fullAddress,
            CASE
                WHEN d.share_gps = 1 THEN ROUND(
                    6371 * ACOS(
                        COS(RADIANS(d.gps_lat)) * COS(RADIANS(h.gps_lat)) *
                        COS(RADIANS(h.gps_lng) - RADIANS(d.gps_lng)) +
                        SIN(RADIANS(d.gps_lat)) * SIN(RADIANS(h.gps_lat))
                    ), 2)
                ELSE 'GPS not shared'
            END AS distanceKm
        FROM 
            new_request nr
        JOIN 
            hospital h ON nr.recipient_id = h.recipient_id
        JOIN 
            donor d ON d.donor_id = :donorId
        WHERE
            (
                (nr.request_type = 'blood' AND d.blood_group = nr.blood_group)
                OR
                (nr.request_type = 'organ' AND d.willing_organ = 1 AND (
                    (nr.organ_type = 'Kidney' AND d.donate_kidney = 1)
                    OR
                    (nr.organ_type = 'Liver' AND d.donate_liver = 1)
                ))
            )
            AND (
                (d.share_gps = 1 AND
                    ROUND(
                        6371 * ACOS(
                            COS(RADIANS(d.gps_lat)) * COS(RADIANS(h.gps_lat)) *
                            COS(RADIANS(h.gps_lng) - RADIANS(d.gps_lng)) +
                            SIN(RADIANS(d.gps_lat)) * SIN(RADIANS(h.gps_lat))
                        ), 2
                    ) < 5
                )
                OR
                (d.share_gps = 0 AND LOWER(d.location) = LOWER(h.city))
            )
        ORDER BY 
            CASE
                WHEN d.share_gps = 1 THEN ROUND(
                    6371 * ACOS(
                        COS(RADIANS(d.gps_lat)) * COS(RADIANS(h.gps_lat)) *
                        COS(RADIANS(h.gps_lng) - RADIANS(d.gps_lng)) +
                        SIN(RADIANS(d.gps_lat)) * SIN(RADIANS(h.gps_lat))
                    ), 2
                )
                ELSE 99999
            END ASC
        """, nativeQuery = true)
    List<DonorMatchDTO> getrequest2(@Param("donorId") Long donorId);}
