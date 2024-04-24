package vn.vt;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;

@Slf4j
@Component
@Aspect
public class TimerAspect {

    @Pointcut("within(@vn.vt.Timer *)")
    public void beansMethod(){};


    @Pointcut("@annotation(vn.vt.Timer)")
    public void beansWithAnnotation(){}

    @Around("beansMethod() || beansWithAnnotation()")
    public Object perfomanceLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        log.info("Таймер включился: {}", Instant.ofEpochMilli(startTime).atZone(ZoneId.systemDefault()).toLocalDateTime());

        Object result = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();

        System.out.println(proceedingJoinPoint.getClass().getName() + " "
                + proceedingJoinPoint.getSignature().toString() + " выполнялся "
                + (endTime - startTime) + " миллисекунд");

        return result;
    }
}
