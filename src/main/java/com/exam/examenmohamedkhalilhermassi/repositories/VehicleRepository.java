package com.exam.examenmohamedkhalilhermassi.repositories;

import com.exam.examenmohamedkhalilhermassi.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository  extends JpaRepository<Vehicle,Long> {
}
