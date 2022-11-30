package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class CurrencyServiceAspect {

    @Pointcut("within(com.demo.service.*)")
    public void withinCurrencyServicePointCut(){

    }

    @Pointcut("@within(com.demo.annotation.Secured)")
    public void withinAnnotationCurrencyPointCut(){}

    @Pointcut("within(com.demo.annotation.InTrascation)")
    public void annotationCurrencyServicePointcut(){}



   // @Before("withinCurrencyServicePointCut()")
            public void beforeCurrencyAdvice(JoinPoint joinPoint){
    String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(String.format("%s%s is invoke with %s parameter before advice in [%s].", className,
            joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()),LocalDateTime.now()));
}

    @Before("withinAnnotationCurrencyPointCut()")
    public  void beforeWithinAnnotationCurrencyAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(String.format("%s%s is invoke with %s parameter before advice in [%s].", className,
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()),LocalDateTime.now()));
    }

    @Before("annotationCurrencyServicePointcut()")
    public  void beforeAnnotationCurrencyAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(String.format("%s%s is invoke with %s parameter before advice in [%s].", className,
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()),LocalDateTime.now()));
    }


}
