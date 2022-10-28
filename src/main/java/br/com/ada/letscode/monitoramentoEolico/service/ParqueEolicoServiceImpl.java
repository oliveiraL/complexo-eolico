package br.com.ada.letscode.monitoramentoEolico.service;

import br.com.ada.letscode.monitoramentoEolico.domain.ComplexoEolico;
import br.com.ada.letscode.monitoramentoEolico.domain.ParqueEolico;
import br.com.ada.letscode.monitoramentoEolico.exceptions.ComplexoEolicoNotFound;
import br.com.ada.letscode.monitoramentoEolico.repository.ComplexoEolicoRepository;
import br.com.ada.letscode.monitoramentoEolico.repository.ParqueEolicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParqueEolicoServiceImpl implements ParqueEolicoService {

    private final ParqueEolicoRepository parqueEolicoRepository;
    private final ComplexoEolicoRepository complexoEolicoRepository;

    @Override
    public ParqueEolico save(ParqueEolico parqueEolico, Long complexoEolicoId) {
        if (complexoEolicoRepository.existsById(complexoEolicoId)){
            ComplexoEolico complexoEolico = new ComplexoEolico();
            complexoEolico.setId(complexoEolicoId);
            parqueEolico.setComplexoEolico(complexoEolico);
            return parqueEolicoRepository.save(parqueEolico);
        }
        throw new ComplexoEolicoNotFound();
    }
}
