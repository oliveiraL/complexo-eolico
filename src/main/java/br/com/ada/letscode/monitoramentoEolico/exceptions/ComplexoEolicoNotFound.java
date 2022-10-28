package br.com.ada.letscode.monitoramentoEolico.exceptions;

public class ComplexoEolicoNotFound extends RuntimeException {
    public ComplexoEolicoNotFound() {
        super("Complexo Eolico não existe");
    }
}
