package com.gb;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAspect {

    @Pointcut("within(@com.gb.Timer *)")
    public void beansMethod(){};


    @Pointcut("@annotation(com.gb.Timer)")
    public void beansWithAnnotation(){}

    @Around("beansMethod() || beansWithAnnotation()")
    public Object perfomanceLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();

        System.out.println(proceedingJoinPoint.getClass().getName() + " "
                + proceedingJoinPoint.getSignature().getName() + " выполнялся "
                + (endTime - startTime) + " миллисекунд");

        return result;
    }
}
