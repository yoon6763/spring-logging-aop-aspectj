package com.test.teststudio;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    // @Logging이 붙은 클래스 또는 메서드에 AOP 적용
    @Before("@within(com.test.teststudio.Logging) || @annotation(com.test.teststudio.Logging)")
    public void logBeforeMethod(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        Object[] args = joinPoint.getArgs();
        Parameter[] parameters = method.getParameters();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            sb.append(parameters[i].getName()).append(" : ").append(args[i]);
            if (i < args.length - 1) {
                sb.append(", ");
            }
        }

        log.info("클래스 : {}, 메서드 : {}, 파라미터 : {}",
                joinPoint.getTarget().getClass().getSimpleName(),
                method.getName(), sb.toString());
    }
}
