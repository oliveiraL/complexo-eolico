package br.com.ada.letscode.monitoramentoEolico.domain;

public class Carro {
    private String modelo;
    private Integer ano;


    public Carro(String modelo, Integer ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }
}
