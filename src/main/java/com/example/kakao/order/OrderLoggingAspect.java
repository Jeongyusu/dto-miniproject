package com.example.kakao.order;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class OrderLoggingAspect {

    @Around("execution(* com.example.kakao.order.OrderRestController.findById(..))")
    public Object doLog(ProceedingJoinPoint joinPoint) {
        try {
            ResponseEntity<OrderResponse.FindByIdDTO> response = (ResponseEntity<OrderResponse.FindByIdDTO>) joinPoint.proceed();
            log.info("response body : {}", response.getBody());
            return response;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}