package com.exam.examenmohamedkhalilhermassi.controller;

import com.exam.examenmohamedkhalilhermassi.entities.Type;
import com.exam.examenmohamedkhalilhermassi.entities.Worker;
import com.exam.examenmohamedkhalilhermassi.services.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.LongFunction;

@RestController
@AllArgsConstructor
@RequestMapping("worker")

public class WorkerController {
    private WorkerService workerService;

    @PostMapping("add")
    public Worker addWorker(@RequestBody Worker worker)
    {
        return workerService.addWorker(worker);
    }
    @PostMapping("affect-reservation/{nic}")
    public Worker affectWorkertoReservation(@PathVariable("nic") String nic, @RequestBody List<Long> idReservation)
    {
        return workerService.affectWorkertoReservation(nic,idReservation);
    }
    @GetMapping("get/{test}/{type}")
    public Float addWorjker(@PathVariable("test") String worker,@PathVariable("type") Type test)
    {
        return workerService.calculateTotalIncomePerWorker(worker,test);
    }


}
