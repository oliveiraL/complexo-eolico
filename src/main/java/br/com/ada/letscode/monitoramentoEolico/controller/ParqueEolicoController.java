package br.com.ada.letscode.monitoramentoEolico.controller;

import br.com.ada.letscode.monitoramentoEolico.domain.ParqueEolico;
import br.com.ada.letscode.monitoramentoEolico.service.ParqueEolicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("complexo-eolicos/{complexoEolicoId}/parques-eolicos")
@RequiredArgsConstructor
public class ParqueEolicoController {

    private final ParqueEolicoService parqueEolicoService;

    @PostMapping
    public ParqueEolico save(@RequestBody ParqueEolico parqueEolico, @PathVariable Long complexoEolicoId){
        return parqueEolicoService.save(parqueEolico, complexoEolicoId);
    }
}
