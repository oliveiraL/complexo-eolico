package br.com.ada.letscode.monitoramentoEolico.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoDTO {
    private String cep;
    private String logradouro;
    private String numero;
}
