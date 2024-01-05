package com.exam.examenmohamedkhalilhermassi.services;

import com.exam.examenmohamedkhalilhermassi.entities.Reservation;
import com.exam.examenmohamedkhalilhermassi.entities.Status;
import com.exam.examenmohamedkhalilhermassi.entities.Type;
import com.exam.examenmohamedkhalilhermassi.entities.Worker;
import com.exam.examenmohamedkhalilhermassi.repositories.ReservationRepository;
import com.exam.examenmohamedkhalilhermassi.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerService {
    private WorkerRepository workerRepository;
    private ReservationRepository reservationRepository;
    public Worker addWorker(Worker worker)
    {
        return workerRepository.save(worker);
    }

    public Worker affectWorkertoReservation(String nic, List<Long> idReservation)
    {
        Worker worker = workerRepository.findByNic(nic);
        Reservation reservation = new Reservation();

        List<Reservation> reservations = worker.getReservations();
        for (int i=0;i<idReservation.size();i++)
        {
            reservation = reservationRepository.findById(idReservation.get(i)).get();
            reservation.setStatus(Status.CONFIRMED);
            reservation.setWorker(worker);
            reservations.add(reservation);
        }

        worker.setReservations(reservations);
        reservationRepository.save(reservation);
        return workerRepository.save(worker);

    }


    public Float calculateTotalIncomePerWorker(String name, Type typeService)
    {
    Worker worker = workerRepository.findByName(name);
    Float total=0F;

    for (int i=0;i<worker.getReservations().size();i++)
    {
        for (int j=0;j<worker.getReservations().get(i).getWashingServices().size();j++)
        {
            if (worker.getReservations().get(i).getStatus().toString().equals("CONFIRMED") && worker.getReservations().get(i).getWashingServices().get(j).getType().equals(typeService))
            {
            total += worker.getReservations().get(i).getWashingServices().get(j).getPrice();
            }
        }

    }
    return total;


    }
}
