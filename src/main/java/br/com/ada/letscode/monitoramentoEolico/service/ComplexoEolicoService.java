package br.com.ada.letscode.monitoramentoEolico.service;

import br.com.ada.letscode.monitoramentoEolico.domain.ComplexoEolico;

import java.util.List;

public interface ComplexoEolicoService {
    List<ComplexoEolico> list();
    ComplexoEolico salvar(ComplexoEolico complexoEolico);
    ComplexoEolico getById(Long id);
}
