package br.com.ada.letscode.monitoramentoEolico.controller;

import br.com.ada.letscode.monitoramentoEolico.domain.ComplexoEolico;
import br.com.ada.letscode.monitoramentoEolico.domain.Endereco;
import br.com.ada.letscode.monitoramentoEolico.dto.ComplexoEolicoDTO;
import br.com.ada.letscode.monitoramentoEolico.dto.ComplexoEolicoSaveDTO;
import br.com.ada.letscode.monitoramentoEolico.service.ComplexoEolicoService;
import br.com.ada.letscode.monitoramentoEolico.service.ComplexoEolicoServiceImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/*
 *
 * GET /complexo-eolicos -> lita de complexo eolico
 * GET .../complexo-eolicos/{id} -> Busca complexo especifico
 * GET .../complexo-eolicos/{nome}
 *
 * GET /complexo-eolicos/1
 * GET /complexo-eolicos/lucio
 *
 *GET /usuarios
 *POST /usarios
 *
 *
 * */

@RestController
@RequestMapping("complexo-eolicos")
public class ComplexoEolicoController {

    private final ComplexoEolicoService complexoEolicoService;

    public ComplexoEolicoController(ComplexoEolicoService complexoEolicoService) {
        this.complexoEolicoService = complexoEolicoService;
    }

    @GetMapping("{id}")
    ComplexoEolico getById(@PathVariable Long id) {
        return complexoEolicoService.getById(id);
    }

    @GetMapping
    List<ComplexoEolicoDTO> list(String name) {

        List<ComplexoEolico> list = complexoEolicoService.list(name);

        return list.stream().map(complexo -> ComplexoEolicoDTO.builder()
                .name(complexo.getName())
                .id(complexo.getId()).build()).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ComplexoEolico save(@RequestBody @Valid ComplexoEolicoSaveDTO complexo) {
        ComplexoEolico complexoEolico = ComplexoEolico.builder()
                .name(complexo.getName())
                .endereco(Endereco.builder()
                        .logradouro(complexo.getEndereco().getLogradouro())
                        .cep(complexo.getEndereco().getCep())
                        .numero(complexo.getEndereco().getNumero())
                        .build())
                .build();
        return complexoEolicoService.save(complexoEolico);
    }

    @PutMapping("{id}")
    ComplexoEolico update(@PathVariable Long id, @RequestBody ComplexoEolico complexoEolico) {
        return complexoEolicoService.update(id, complexoEolico);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        complexoEolicoService.delete(id);
    }

}
