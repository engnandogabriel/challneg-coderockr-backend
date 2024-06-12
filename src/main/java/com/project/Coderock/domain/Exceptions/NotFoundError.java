package com.project.Coderock.domain.Exceptions;

public class NotFoundError extends Exception{
    public NotFoundError(String message){
        super("NotFoundError: " +message);
    }
}
