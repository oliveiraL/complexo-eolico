package br.com.ada.letscode.monitoramentoEolico.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String cep;
    private String logradouro;
    private String numero;
}
