package com.exam.examenmohamedkhalilhermassi.services;

import com.exam.examenmohamedkhalilhermassi.entities.Reservation;
import com.exam.examenmohamedkhalilhermassi.entities.Status;
import com.exam.examenmohamedkhalilhermassi.entities.Vehicle;
import com.exam.examenmohamedkhalilhermassi.entities.Washing_Service;
import com.exam.examenmohamedkhalilhermassi.repositories.ReservationRepository;
import com.exam.examenmohamedkhalilhermassi.repositories.VehicleRepository;
import com.exam.examenmohamedkhalilhermassi.repositories.WashingServiceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class ReservationService {
    private ReservationRepository reservationRepository;
    private VehicleRepository vehicleRepository;
    private WashingServiceRepository washingServiceRepository;
    public Vehicle addVehicleReservationAndAffectToWashingService(Vehicle vehicle, List<Long> idService)
    {


        Reservation reservation = new Reservation();
        reservation.setStatus(Status.PENDING);
        reservation.setTimereservation(LocalDateTime.now().plusHours(3));
        List<Washing_Service> washingServices = new ArrayList<>();
        for (int i=0;i <idService.size();i++)
        {
           Washing_Service washingService = washingServiceRepository.findById(idService.get(i)).get();
           washingServices.add(washingService);
           List<Reservation> reservationList = washingService.getReservations();
           reservationList.add(reservation);
           washingService.setReservations(reservationList);

        }
        //affecter washing service à une reservation
        reservation.setWashingServices(washingServices);
        //affecter une reservation à un washing service


        //
        //affecter reservation à un véhicule
        List<Reservation> reservations = vehicle.getReservations();
        if (reservations == null)
        {
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
        vehicle.setReservations(reservations);
        //
        reservationRepository.save(reservation);

        return vehicleRepository.save(vehicle);

    }


    @Scheduled(fixedRate = 15000)
    public void getReservation ()
    {


        log.info(reservationRepository.ReservationOrderedbyTimeandStatus(Status.PENDING).toString());


    }

    public Map<String,Long> getListServiceAndNbrservation()
    {
        Map<String,Long> myMap = new HashMap<>();
        Long polissage= 0L,external=0L,internal=0L;
        for (int i=0;i<reservationRepository.findAll().size();i++)
        {
            for (int j=0;j<reservationRepository.findAll().get(i).getWashingServices().size();j++)
            {
                if (reservationRepository.findAll().get(i).getWashingServices().get(j).getType().toString().equals("POLISHING"))
                {
                    polissage+=1;
                }
                else if (reservationRepository.findAll().get(i).getWashingServices().get(j).getType().toString().equals("EXTERNAL_WASHING"))
                {
                    external+=1;
                }
                else if (reservationRepository.findAll().get(i).getWashingServices().get(j).getType().toString().equals("INTERNAL_WASHING"))
                {
                    internal+=1;
                }
            }
        }
        myMap.put("POLISHING",polissage);

        myMap.put("EXTERNAL_WASHING",external);
        myMap.put("INTERNAL_WASHING",internal);
     return myMap;
    }


}
