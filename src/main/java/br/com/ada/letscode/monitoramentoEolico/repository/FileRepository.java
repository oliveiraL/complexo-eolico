package br.com.ada.letscode.monitoramentoEolico.repository;

import br.com.ada.letscode.monitoramentoEolico.domain.File;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends CrudRepository<File, Long> {
}
