package org.example.advice;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {

//    @Around("execution(public * org.example.*.*.*(..))")
//    public void log(ProceedingJoinPoint joinPoint){
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method targetMethod = signature.getMethod();
//        System.out.println(targetMethod.getDeclaringClass().getName() + "类中的" + targetMethod.getName() + " 方法调用了");
//    }

}