package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.SchoolApp.Web.Dtos.Request.ModuleRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModuleMappper {
    ModuleRequest toDto(ModulesEntity entity);
    ModulesEntity toEntity(ModuleRequest dto);
    List<ModuleRequest> toDtos(List<ModulesEntity> entities);
    List<ModulesEntity> toEntities(List<ModuleRequest> dtos);
}
