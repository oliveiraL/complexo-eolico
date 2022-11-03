package br.com.ada.letscode.monitoramentoEolico.exceptions;

public class FileNotFound extends RuntimeException {
    public FileNotFound() {
        super("Arquivo não existe");
    }
}

