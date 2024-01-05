package com.exam.examenmohamedkhalilhermassi.services;

import com.exam.examenmohamedkhalilhermassi.entities.Washing_Service;
import com.exam.examenmohamedkhalilhermassi.repositories.WashingServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WashingService {
    private WashingServiceRepository washingServiceRepository;
    public void addWashingService(List<Washing_Service> washing_services)
    {
        washingServiceRepository.saveAll(washing_services);
    }
}
