package com.example.jozinko.dev.boundary;

import com.example.jozinko.dev.entity.Developer;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ping")
public class PingResource {

    @Inject
    private DeveloperShop shop;

    @GET
    @Timeout(1500)
    @Fallback(fallbackMethod = "fallback")
    @Bulkhead(value = 2)
    public Developer ping() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("PING SUCCESSFUL");
        return shop.theOne();
    }

    public Developer fallback() {
        System.out.println("FALLBACK");
        return shop.theOne();
    }

}
