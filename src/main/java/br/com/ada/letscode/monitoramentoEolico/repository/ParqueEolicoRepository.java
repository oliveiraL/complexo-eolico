package br.com.ada.letscode.monitoramentoEolico.repository;

import br.com.ada.letscode.monitoramentoEolico.domain.ParqueEolico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueEolicoRepository extends CrudRepository<ParqueEolico, Long>{}