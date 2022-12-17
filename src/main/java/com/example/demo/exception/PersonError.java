package com.example.demo.exception;

import com.example.demo.model.Person;

public enum PersonError {
    LETTER_REQUIRED("Nie możesz wziąć udziału w losowaniu jeśli nie napiszesz listu do Świętego Mikołaja"),
    INCORRECT_DRAW("Wylosowałaś/eś sam siebie. Spróbuj jeszcze raz!"),
    INCORRECT_DATA("Wprowadzono nieprawidłowe dane. Upewnij się, że wprowadzone dane są prawidłowe.");
    private String message;

    PersonError(String message){
        this.message = message;
    }

    public String getMessage(){ return message;}
}
