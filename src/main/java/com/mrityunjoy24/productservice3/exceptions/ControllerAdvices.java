package com.mrityunjoy24.productservice3.exceptions;

import com.mrityunjoy24.productservice3.dtos.ExceptionDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class ControllerAdvices {
//
//    @ExceptionHandler(NotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleNotFoundException(
//            ControllerAdvices notFoundException
//    ) {
//
//        return new ResponseEntity(
//                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
//                HttpStatus.NOT_FOUND
//        );
//    }
//
//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    private ResponseEntity<ExceptionDto> handleArrayIndexOutOfBound(
//            ArrayIndexOutOfBoundsException notFoundException
//    ) {
//
//        return new ResponseEntity(
//                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
//                HttpStatus.NOT_FOUND
//        );
//    }
}
