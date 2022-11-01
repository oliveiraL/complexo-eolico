package br.com.ada.letscode.monitoramentoEolico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
public class ComplexoEolicoSaveDTO {

    @NotBlank
    private String name;

    @Valid
    private EnderecoDTO endereco;
}
