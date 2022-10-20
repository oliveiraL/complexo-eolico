package br.com.ada.letscode.monitoramentoEolico.service;

import br.com.ada.letscode.monitoramentoEolico.domain.ComplexoEolico;
import br.com.ada.letscode.monitoramentoEolico.repository.ComplexoEolicoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplexoEolicoServiceImpl implements ComplexoEolicoService {

    private final ComplexoEolicoRepository complexoEolicoRepository;

    private List<ComplexoEolico> list = new ArrayList<>();

    private Long count = 0L;

    @Override
    public List<ComplexoEolico> list() {
        return IterableUtils.toList(complexoEolicoRepository.findAll());
    }


    @Override
    public ComplexoEolico save(ComplexoEolico complexoEolico) {
        return complexoEolicoRepository.save(complexoEolico);
    }

    @Override
    public ComplexoEolico getById(Long id) {
        return list.stream().filter(complexoEolico -> complexoEolico.getId().equals(id)).findFirst().orElseGet(null);
    }

    @Override
    public ComplexoEolico update(Long id, ComplexoEolico complexoEolico) {
        complexoEolico.setId(id);
        int index = list.indexOf(complexoEolico);
        return list.set(index, complexoEolico);
    }

    @Override
    public void delete(Long id) {
        ComplexoEolico complexoEolico = new ComplexoEolico();
        complexoEolico.setId(id);
        list.remove(complexoEolico);
    }
}
