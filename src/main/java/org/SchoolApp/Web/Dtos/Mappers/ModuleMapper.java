package org.SchoolApp.Web.Dtos.Mappers;

import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.SchoolApp.Web.Dtos.Request.ModuleRequestDto;
import org.SchoolApp.Web.Dtos.Response.ModuleResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuleMapper {

    ModulesEntity toEntity(ModuleRequestDto moduleRequestDto);

    ModuleResponseDto toDto(ModulesEntity modulesEntity);
}
