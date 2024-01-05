package com.exam.examenmohamedkhalilhermassi.repositories;

import com.exam.examenmohamedkhalilhermassi.entities.Reservation;
import com.exam.examenmohamedkhalilhermassi.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("select r from Reservation r where r.status =:status order by r.timereservation")
    List<Reservation> ReservationOrderedbyTimeandStatus(@Param("status") Status status);
}
