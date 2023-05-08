package com.example.springaopdemo1.testduration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class ExecDurationAspect {
    private static final Logger logger = LogManager.getLogger();

    @Around("execution(@com.example.springaopdemo1.testduration.ExecDuration * *(..))")
    public Object duration(ProceedingJoinPoint pjp) throws Throwable {
        LocalDateTime start = LocalDateTime.now();
        Object output = pjp.proceed();
        LocalDateTime end = LocalDateTime.now();
        Method interfaceMethod = ((MethodSignature) pjp.getSignature()).getMethod();

        logger.info("{}, duration = {}", interfaceMethod.getName(),duration(start, end));
        return output;
    }

    public static String duration(LocalDateTime before, LocalDateTime after) {
        return (Duration.between(before, after).getSeconds() > 0 ?
                Duration.between(before, after).getSeconds() + " (s)" : TimeUnit.MILLISECONDS.convert(Duration.between(before, after).getNano(), TimeUnit.NANOSECONDS) + " (ms)");
    }
}
