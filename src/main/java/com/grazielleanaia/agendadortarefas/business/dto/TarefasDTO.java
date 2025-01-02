package com.grazielleanaia.agendadortarefas.business.dto;

import com.grazielleanaia.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class TarefasDTO {

    private String id;

    private String nomeTarefa;

    private String descricao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataEvento;

    private String emailUsuario;

    private LocalDateTime dataAlteracao;

    private StatusNotificacaoEnum statusNotificacaoEnum;
}
