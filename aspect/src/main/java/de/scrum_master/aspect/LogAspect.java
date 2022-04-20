package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {
    @AfterThrowing(value = "execution(* *(..))", throwing = "e")
    public void log(JoinPoint thisJoinPoint, Throwable e) {
        System.out.println("count = " + ", " + thisJoinPoint + " -> " + e);
    }

    @Pointcut("execution(* *(..))")
    public void atExecution() { }

    @Pointcut("@annotation(de.scrum_master.common.CollectException) && execution(* *(..))")
    public void annotationPointCutDefinition() { }

    @Before("cflow(annotationPointCutDefinition()) && handler(*) && args(e)")
    public void logCaughtException(JoinPoint thisJoinPoint, Throwable e) {
        System.out.println(thisJoinPoint + " -> " + e.getClass().getCanonicalName());
    }
}
