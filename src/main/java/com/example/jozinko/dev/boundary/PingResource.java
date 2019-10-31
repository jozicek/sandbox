package com.example.jozinko.dev.boundary;

import com.example.jozinko.dev.entity.Developer;
import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ping")
@Singleton
public class PingResource {

    @Inject
    private DeveloperShop shop;

    @GET
    @Metered
    public Developer ping() {
        return shop.theOne();
    }

}
