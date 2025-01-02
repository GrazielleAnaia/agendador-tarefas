package com.grazielleanaia.agendadortarefas.controller;


import com.grazielleanaia.agendadortarefas.business.TarefaService;
import com.grazielleanaia.agendadortarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")

@RequiredArgsConstructor

public class TarefasController {

    private final TarefaService tarefaService;

    @PostMapping
public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto,
                                                @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefaService.gravarTarefa(token, dto));
    }

}
