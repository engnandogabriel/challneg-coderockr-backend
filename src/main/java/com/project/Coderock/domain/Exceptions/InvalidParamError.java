package com.project.Coderock.domain.Exceptions;

public class InvalidParamError extends Exception {
    public InvalidParamError(String message){
        super("InvalidParamError: "+message);
    }
}
