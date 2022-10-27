package br.com.ada.letscode.monitoramentoEolico.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
public class ParqueEolico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private boolean activated;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    @ManyToOne
    private ComplexoEolico complexoEolico;
}
