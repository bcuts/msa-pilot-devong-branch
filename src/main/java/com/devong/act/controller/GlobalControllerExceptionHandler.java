package com.devong.act.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.NO_CONTENT)  // 204
    @ExceptionHandler(EntityNotFoundException.class)
    public void entityNotFound(HttpServletResponse response, Exception exception) throws IOException {
        response.sendError(HttpServletResponse.SC_NO_CONTENT, exception.getMessage());
        // Nothing to do
    }

    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(EntityExistsException.class)
    public void entityExist(HttpServletResponse response, Exception exception) throws IOException{
        response.sendError(HttpServletResponse.SC_CONFLICT, exception.getMessage());
        // Nothing to do
    }
}
