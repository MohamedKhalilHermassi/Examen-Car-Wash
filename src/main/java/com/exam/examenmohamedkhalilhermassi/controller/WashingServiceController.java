package com.exam.examenmohamedkhalilhermassi.controller;


import com.exam.examenmohamedkhalilhermassi.entities.Washing_Service;
import com.exam.examenmohamedkhalilhermassi.repositories.WashingServiceRepository;
import com.exam.examenmohamedkhalilhermassi.services.WashingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("washing-service")
public class WashingServiceController {
    private WashingService washingService;
    @PostMapping("add-all")
    public void addAllWashingService(@RequestBody List<Washing_Service> washing_Services)
    {
        washingService.addWashingService(washing_Services);
    }
}
