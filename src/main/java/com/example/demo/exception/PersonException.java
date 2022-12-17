package com.example.demo.exception;

public class PersonException extends RuntimeException {

    private PersonError personError;

    public PersonException(PersonError personError){
        this.personError = personError;
    }

    public PersonError getPersonError() {
        return personError;
    }
}
