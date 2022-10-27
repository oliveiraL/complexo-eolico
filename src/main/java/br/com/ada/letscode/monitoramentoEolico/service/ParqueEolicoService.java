package br.com.ada.letscode.monitoramentoEolico.service;

import br.com.ada.letscode.monitoramentoEolico.domain.ParqueEolico;

public interface ParqueEolicoService {
    ParqueEolico save(ParqueEolico parqueEolico, Long complexoEolicoId);
}
