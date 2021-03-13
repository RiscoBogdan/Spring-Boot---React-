package com.example.SpringBackEnd.exception;
//whenever a resource doesn't exist int database it throws this exception

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//whenever a record doesn't exist in database the restAPI will throw this exception
@ResponseStatus(value = HttpStatus.NOT_FOUND)//api will return a not found exception to the client
public class ReourceNotFoundException extends RuntimeException{

    static final long serialVersionUID = 1L;
    public ReourceNotFoundException(String msg){
        super(msg);//pass this message to the superclass
    }

}
