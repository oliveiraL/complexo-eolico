package br.com.ada.letscode.monitoramentoEolico.controller;

import br.com.ada.letscode.monitoramentoEolico.domain.Carro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello-world")
public class HelloWorld {

    @RequestMapping("/home")
    @ResponseBody
    String helloWorld(){
        return "Hello World";
    }

    @GetMapping("carro")
    Carro getCarro(){
        return new Carro("Celta", 2010);
    }

}
