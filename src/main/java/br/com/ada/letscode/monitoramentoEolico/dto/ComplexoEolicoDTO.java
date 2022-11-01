package br.com.ada.letscode.monitoramentoEolico.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ComplexoEolicoDTO {
    private String name;
    private Long id;
}
