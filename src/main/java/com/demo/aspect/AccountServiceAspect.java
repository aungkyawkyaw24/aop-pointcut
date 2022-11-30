package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;

public class AccountServiceAspect {

    @Pointcut("this(com.demo.service.AccountService)")
    public void thisPointcutAccountService(){}

    public void beforeAccountServiceAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked with before advice in[%s].", joinPoint.getSignature().getName())

        );
    }
}
