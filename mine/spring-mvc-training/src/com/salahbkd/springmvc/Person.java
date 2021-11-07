package com.salahbkd.springmvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {

    @NotNull(message="required")
    @Size(min=1, message="required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
