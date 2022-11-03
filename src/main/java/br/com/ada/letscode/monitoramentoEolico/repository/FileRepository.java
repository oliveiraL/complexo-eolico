package br.com.ada.letscode.monitoramentoEolico.repository;

import br.com.ada.letscode.monitoramentoEolico.domain.File;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<File, Long> {
}
