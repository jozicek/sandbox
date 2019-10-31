package com.example.jozinko.zoo;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ZooException extends WebApplicationException {

    public ZooException() {
        super(Response.status(Response.Status.BAD_REQUEST).header("message", "zoo is closed").build());
    }
}
