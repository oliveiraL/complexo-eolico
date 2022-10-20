package br.com.ada.letscode.monitoramentoEolico.repository;

import br.com.ada.letscode.monitoramentoEolico.domain.ComplexoEolico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplexoEolicoRepository extends CrudRepository<ComplexoEolico, Long> {
}
