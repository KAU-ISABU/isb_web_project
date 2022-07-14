package kau.isabu.web_project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* kau.isabu.web_project..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start=System.currentTimeMillis();
        System.out.println("START: "+ joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish=System.currentTimeMillis();
            long ret=finish-start;
            System.out.println("END: " + joinPoint.toString() + " "+ret+" ms");
        }
    }
}
