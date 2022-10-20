package br.com.ada.letscode.monitoramentoEolico.controller;

import br.com.ada.letscode.monitoramentoEolico.domain.ComplexoEolico;
import br.com.ada.letscode.monitoramentoEolico.service.ComplexoEolicoService;
import br.com.ada.letscode.monitoramentoEolico.service.ComplexoEolicoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    List<ComplexoEolico> list() {
        return complexoEolicoService.list();
    }

    @PostMapping
    ComplexoEolico save(@RequestBody ComplexoEolico complexoEolico) {
        return complexoEolicoService.save(complexoEolico);
    }

    @PutMapping("{id}")
    ComplexoEolico update(@PathVariable Long id, @RequestBody ComplexoEolico complexoEolico) {
        return complexoEolicoService.update(id, complexoEolico);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id){
        complexoEolicoService.delete(id);
    }

}
