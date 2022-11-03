package br.com.ada.letscode.monitoramentoEolico.controller;

import br.com.ada.letscode.monitoramentoEolico.domain.File;
import br.com.ada.letscode.monitoramentoEolico.dto.FileDTO;
import br.com.ada.letscode.monitoramentoEolico.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping("files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    @ResponseBody
    public FileDTO uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File newFile = fileService.save(file);
        return FileDTO.builder()
                .name(newFile.getName())
                .type(newFile.getType())
                .size(newFile.getData().length)
                .url("/files/" + newFile.getId())
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        File file = fileService.getById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getData());
    }


    @GetMapping
    @ResponseBody
    public List<FileDTO> listAll() {
        return fileService.listAll().stream().map(file -> FileDTO.builder()
                .name(file.getName())
                .type(file.getType())
                .size(file.getData().length)
                .url("/files/" + file.getId())
                .build()).toList();
    }

}
