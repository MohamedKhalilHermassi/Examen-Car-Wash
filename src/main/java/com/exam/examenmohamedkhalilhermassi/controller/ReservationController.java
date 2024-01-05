package com.exam.examenmohamedkhalilhermassi.controller;

import com.exam.examenmohamedkhalilhermassi.entities.Vehicle;
import com.exam.examenmohamedkhalilhermassi.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("reservation")
public class ReservationController {
    private ReservationService reservationService;

    @PostMapping("add-with-vehicule/{idService}")
    public Vehicle addVehicleReservationAndAffectToWashingService(@RequestBody Vehicle vehicle, @PathVariable("idService") List<Long> idService)
    {
        return reservationService.addVehicleReservationAndAffectToWashingService(vehicle,idService);
    }

    @GetMapping("getMap")
    public Map<String,Long> getListService()
    {
        return reservationService.getListServiceAndNbrservation();
    }

}