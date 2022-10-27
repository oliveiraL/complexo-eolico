package br.com.ada.letscode.monitoramentoEolico.service;

import br.com.ada.letscode.monitoramentoEolico.domain.ComplexoEolico;
import br.com.ada.letscode.monitoramentoEolico.repository.ComplexoEolicoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplexoEolicoServiceImpl implements ComplexoEolicoService {

    private final ComplexoEolicoRepository complexoEolicoRepository;

    @Override
    public List<ComplexoEolico> list(String name) {
        if (name == null) {
            return IterableUtils.toList(complexoEolicoRepository.findAll());
        }
        return IterableUtils.toList(complexoEolicoRepository.findAllByNameContains(name));
    }


    @Override
    public ComplexoEolico save(ComplexoEolico complexoEolico) {
        return complexoEolicoRepository.save(complexoEolico);
    }

    @Override
    public ComplexoEolico getById(Long id) {
        return complexoEolicoRepository.findById(id).get();
    }

    @Override
    public ComplexoEolico update(Long id, ComplexoEolico complexoEolico) {
        complexoEolico.setId(id);
        return complexoEolicoRepository.save(complexoEolico);
    }

    @Override
    public void delete(Long id) {
        complexoEolicoRepository.deleteById(id);
    }
}
