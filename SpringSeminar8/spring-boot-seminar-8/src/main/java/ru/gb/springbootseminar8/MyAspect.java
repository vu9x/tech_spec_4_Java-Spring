package ru.gb.springbootseminar8;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspect {

    // Advice:
    // before
    // afterReturning
    // afterThrowing
    // after
    // around


    @Before("execution(* ru.gb.springbootseminar8.MyServiceBean.*(..))")
    public void myAspectBefore(JoinPoint joinPoint){
        System.out.println("args: " + Arrays.toString(joinPoint.getArgs()));
    }
//
//    @AfterReturning(value = "execution(* ru.gb.springbootseminar8.MyServiceBean.*(..))", returning = "answer")
//    public void afterReturning(JoinPoint joinPoint, Object answer){
//        System.out.println("Answer: " + answer);
//    }
//
//    @Pointcut("execution(* ru.gb.springbootseminar8.MyServiceBean.*(..))")
//    public void myServiceBeanMethod(){}
//
//    @Before("myServiceBeanMethod()")
//    public void beforePointcut(JoinPoint joinPoint){
//        System.out.println("before PointCut args: " + Arrays.toString(joinPoint.getArgs()));
//    }
//
//    @AfterThrowing(value = "myServiceBeanMethod()", throwing = "e")
//    public void afterThrowing(Throwable e){
//        System.out.println(e.getMessage() + " 1");
//    }
//
//    @Around("myServiceBeanMethod()")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint){
//        try{
//            Object result = proceedingJoinPoint.proceed();
//            return result;
//        } catch (Throwable e){
//            System.out.println(e.getMessage() + " 2");
//            return "Было исключение";
//        }
//
//    }
}
