package sample.data.jpa.metrics;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Aspect
@Configuration
public class RestLogger {
    private Logger myLogger= Logger.getLogger(getClass().getName());

    /*
    * Aspect exécuté avant tout appel rest (appel à toute méthode des classes du package rest)
    * */
    @Before("execution(* sample.data.jpa.rest.*.*(..))")
    public void restCalledDone(JoinPoint point) {
        //we can see this output on default output : look for string "Before calling rest method"
        myLogger.info("Before calling rest method : " + point.getSignature().toShortString());
    }
}
