package br.com.ada.letscode.monitoramentoEolico.service;

import br.com.ada.letscode.monitoramentoEolico.domain.ComplexoEolico;

import java.util.List;

public interface ComplexoEolicoService {
    List<ComplexoEolico> list(String name);
    ComplexoEolico save(ComplexoEolico complexoEolico);
    ComplexoEolico getById(Long id);
    ComplexoEolico update(Long id, ComplexoEolico complexoEolico);
    void delete(Long id);
}
