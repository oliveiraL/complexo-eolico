package br.com.ada.letscode.monitoramentoEolico.config;


import br.com.ada.letscode.monitoramentoEolico.exceptions.ComplexoEolicoNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HandlerException {


    @ExceptionHandler({ComplexoEolicoNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIError handlerExceptionNotFound(Exception exception) {
        APIError apiError = APIError.builder()
                .message(exception.getMessage())
                .code("ERROR0001")
                .build();
        return apiError;
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIError handlerExceptionValidation(MethodArgumentNotValidException exception) {


        List<FieldErrorDTO> errors = exception.getAllErrors().stream().map(error -> {
            FieldError fieldError = (FieldError) error;
            return FieldErrorDTO.builder().name(fieldError.getField())
                    .error(fieldError.getDefaultMessage()).build();
        }).toList();

        APIError apiError = APIError.builder()
                .message("Validation failed for argument")
                .code("ERROR0001")
                .error(errors)
                .build();
        return apiError;
    }


}
