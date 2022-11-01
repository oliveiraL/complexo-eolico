package br.com.ada.letscode.monitoramentoEolico.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComplexoEolico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private boolean activated;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    @OneToMany(mappedBy = "complexoEolico")
    @JsonIgnoreProperties("complexoEolico")
    private List<ParqueEolico> parqueEolicos;
}
