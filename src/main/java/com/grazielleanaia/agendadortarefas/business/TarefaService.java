package com.grazielleanaia.agendadortarefas.business;


import com.grazielleanaia.agendadortarefas.business.dto.TarefasDTO;
import com.grazielleanaia.agendadortarefas.business.mapper.TarefaConverter;
import com.grazielleanaia.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.grazielleanaia.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.grazielleanaia.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.grazielleanaia.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
        String email = jwtUtil.extraiEmailToken(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
       return tarefaConverter.paraListaTarefasDTO(
               tarefasRepository.findByDataEventoBetween(dataInicial, dataFinal));
    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token) {
        String email = jwtUtil.extraiEmailToken(token.substring(7));
        List<TarefasEntity> listaTarefas = tarefasRepository.findByEmailUsuario(email);

        return tarefaConverter.paraListaTarefasDTO(listaTarefas);
    }
}
