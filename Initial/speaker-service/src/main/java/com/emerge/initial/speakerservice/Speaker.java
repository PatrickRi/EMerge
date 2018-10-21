package com.emerge.initial.speakerservice;

public class Speaker {

    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public Speaker setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Speaker setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Speaker setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}

