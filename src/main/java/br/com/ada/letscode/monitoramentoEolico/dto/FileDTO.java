package br.com.ada.letscode.monitoramentoEolico.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FileDTO {
    private String name;
    private String url;
    private String type;
    private long size;
}
