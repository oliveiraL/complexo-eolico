package br.com.ada.letscode.monitoramentoEolico.controller;

import br.com.ada.letscode.monitoramentoEolico.domain.ComplexoEolico;
import br.com.ada.letscode.monitoramentoEolico.service.ComplexoEolicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("complexo-eolicos")
public class ComplexoEolicoController {


    private ComplexoEolicoService complexoEolicoService;

    @Autowired
    public void setComplexoEolicoService(ComplexoEolicoService complexoEolicoService) {
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
    ComplexoEolico salvar(@RequestBody ComplexoEolico complexoEolico) {
        return complexoEolicoService.salvar(complexoEolico);
    }


    //DELETE -> localhost:8080/complexo-eolicos/{id}

    //PUT -> localhost:8080/complexo-eolicos/{id}
    /**
     * body {
     *     nome:
     *     endereco:
     * }
     */

}
