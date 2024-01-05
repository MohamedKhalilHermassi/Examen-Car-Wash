package com.exam.examenmohamedkhalilhermassi.repositories;

import com.exam.examenmohamedkhalilhermassi.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {
    Worker findByNic(String nic);
    Worker findByName(String name);
}
