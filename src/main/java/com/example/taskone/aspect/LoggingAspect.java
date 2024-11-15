package com.example.taskone.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.taskone.service.TaskService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Вызов метода: {} с аргументами: {}", joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
    }


    @AfterThrowing(pointcut = "execution(* com.example.taskone.service.TaskService.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        logger.error("Исключение в методе {} с аргументами {}: {}", joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()), ex.getMessage());
    }


    @AfterReturning(pointcut = "execution(* com.example.taskone.service.TaskService.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Метод {} выполнен успешно. Возвращаемое значение: {}", joinPoint.getSignature(), result);
    }


    @Around("execution(* com.example.taskone.service.TaskService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("Метод {} стартовал", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Метод {} закончил за {} ms", joinPoint.getSignature(), (endTime - startTime));
        return result;
    }
}
