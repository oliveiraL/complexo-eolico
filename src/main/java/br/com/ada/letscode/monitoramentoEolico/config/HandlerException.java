package br.com.ada.letscode.monitoramentoEolico.config;


import br.com.ada.letscode.monitoramentoEolico.exceptions.ComplexoEolicoNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {


    @ExceptionHandler({ComplexoEolicoNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIError handlerExceptionNotFound(Exception exception){
        APIError apiError = APIError.builder()
                .message(exception.getMessage())
                .code("ERROR0001")
                .build();
        return apiError;
    }
}
