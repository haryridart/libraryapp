package com.haryridart.libraryapp.exception;

import com.haryridart.libraryapp.payload.ApiResponse;
import com.haryridart.libraryapp.payload.BookResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    // handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BookResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        BookResponse bookResponse = new BookResponse();
        bookResponse.setSuccess(false);
        bookResponse.setMessage(message);
        return new ResponseEntity<BookResponse>(bookResponse, HttpStatus.NOT_FOUND);
    }
}
