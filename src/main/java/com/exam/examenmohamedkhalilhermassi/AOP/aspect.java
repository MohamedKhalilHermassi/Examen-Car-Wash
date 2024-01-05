package com.exam.examenmohamedkhalilhermassi.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class aspect {
    @AfterReturning(pointcut = "execution(* com.exam.examenmohamedkhalilhermassi.services.ReservationService.addVehicleReservationAndAffectToWashingService(..))", returning = "result")
    public void logStringParamMethods(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
       log.info("Waiting for a worker");
    }
}

