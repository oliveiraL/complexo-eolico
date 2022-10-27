package br.com.ada.letscode.monitoramentoEolico.repository;

import br.com.ada.letscode.monitoramentoEolico.domain.ComplexoEolico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplexoEolicoRepository extends CrudRepository<ComplexoEolico, Long> {

    // select * from complexo where nome = 'nome' and actived = true
    List<ComplexoEolico> findAllByNameContains(String name);
    boolean existsByName(String name);


    @Query("FROM ComplexoEolico where name like '%:name%'")
    List<ComplexoEolico> findName(String name);

    @Query(value = "select * from complexo_eolico where name is null", nativeQuery = true)
    List<ComplexoEolico> findName2(String name);
}
