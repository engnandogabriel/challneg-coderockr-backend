package com.project.Coderock.domain.Exceptions;

public class InvalidOperations extends Exception{
    public InvalidOperations(String message){
        super("InvalidOperation: "+message);
    }
}