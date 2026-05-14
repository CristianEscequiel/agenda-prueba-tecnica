package com.agenda.besysoft.domain.exception;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(String email) {
        super("El email"+ email +" ya existe.");
    }

}
