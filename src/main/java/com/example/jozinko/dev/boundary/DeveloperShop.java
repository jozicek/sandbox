package com.example.jozinko.dev.boundary;

import com.example.jozinko.dev.entity.Developer;

import javax.inject.Inject;

public class DeveloperShop {

    @Inject
    private DevCounter counter;

    public Developer theOne() {
        this.counter.increment();
        return new Developer("Duke", 42);
    }

}
