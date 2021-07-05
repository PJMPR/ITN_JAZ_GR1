package pl.pjatk.artdem.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Dodaj @ControllerAdvice który obsłuży ten błąd i pozwoli nam zwrócić status 400
//oraz body `Exception occurred on request. Exception message: " + tresc_naszego_błędu`
//Niech pod `tresc_naszego_błędu` będzie String przekazywany podczas rzucania błędu.

@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class}) //działaj dla wszystkich wyjtków
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request){

        //String bodyOfResponse = "Some custom explanation here...";
        //return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);

        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);    //bad request - status 400
    }

}
