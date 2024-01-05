package com.exam.examenmohamedkhalilhermassi.repositories;

import com.exam.examenmohamedkhalilhermassi.entities.Washing_Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WashingServiceRepository extends JpaRepository<Washing_Service,Long> {
}
