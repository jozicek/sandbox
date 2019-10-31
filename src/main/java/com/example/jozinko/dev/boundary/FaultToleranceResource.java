package com.example.jozinko.dev.boundary;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.time.temporal.ChronoUnit;

@Path("faultTolerance")
public class FaultToleranceResource {


    @Path("timeout")
    @GET
    @Timeout(value = 1, unit = ChronoUnit.SECONDS)
    @Retry(retryOn = Exception.class, delay = 200, maxRetries = 2)
    @Fallback(SandboxFallbackHandler.class)
    public Response getTimeout() throws InterruptedException {
        Thread.sleep(2000);
        return Response.status(200).build();
    }

    public Response fallback() {
        return Response.status(201).build();
    }


}
