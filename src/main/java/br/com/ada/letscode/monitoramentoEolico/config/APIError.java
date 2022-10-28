package br.com.ada.letscode.monitoramentoEolico.config;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class APIError {
    private String message;
    private String code;
}
