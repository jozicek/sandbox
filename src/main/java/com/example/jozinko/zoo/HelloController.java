package com.example.jozinko.zoo;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.temporal.ChronoUnit;

/**
 *
 */
@Path("/zoo")
@Singleton
public class HelloController {

    @GET
    @Retry(maxRetries = 2, retryOn = ZooException.class, delay = 2, delayUnit = ChronoUnit.SECONDS)
    @Fallback(fallbackMethod = "fallback")
    public String sayHello() {
        System.out.println("attempt");
        throw new ZooException();
    }

    public String fallback() {
        System.out.println("FALLBACK METHOD");
        return "fallback";
    }
}
