package com.example.jozinko.dev.boundary;

import org.eclipse.microprofile.metrics.annotation.Gauge;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.LongAdder;

@ApplicationScoped
public class DevCounter {

    LongAdder longAdder = new LongAdder();

    @Gauge(unit = "counter")
    public int developersCreated() {
        return this.longAdder.intValue();
    }

    public void increment(){
        this.longAdder.increment();
    }

}
