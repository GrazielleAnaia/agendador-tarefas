package com.grazielleanaia.agendadortarefas.business.mapper;

import com.grazielleanaia.agendadortarefas.business.dto.TarefasDTO;
import com.grazielleanaia.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO (TarefasEntity entity);
}
