package aop;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Aspect
public class ProfilerAspect {

    @Around("execution(* aop..*.say*(..))")
    @Before("@annotation(org.springframework.scheduling.annotation.Scheduled)")

    @SneakyThrows
    public Object handleMethodsAnnotatedWithProfiling(ProceedingJoinPoint jp) {

        System.out.println(jp.getTarget().getClass().getSimpleName()+" is going to run his method");
        Object retVal = jp.proceed();
        System.out.println(jp.getSignature().getName()+" is going to run his method");
        return retVal;
    }
}
