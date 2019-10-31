package com.example.jozinko.dev.boundary;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import javax.ws.rs.core.Response;


public class SandboxFallbackHandler implements FallbackHandler<Response> {

    @Override
    public Response handle(ExecutionContext executionContext) {
        return Response.status(201).build();
    }
}
