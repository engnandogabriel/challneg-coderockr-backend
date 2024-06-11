package com.project.Coderock.domain.HandlersService;

import org.springframework.http.HttpStatus;

public record HandlerDTO<T>(HttpStatus status, String message, T body) {

}
