package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Datas.Entity.CompetencesEntity;
import org.SchoolApp.Web.Dtos.Request.CompetenceRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenceMapper {
    CompetenceRequest toDto(CompetencesEntity entity);
    CompetencesEntity toEntity(CompetenceRequest dto);
    List<CompetenceRequest> toDtos(List<CompetencesEntity> entities);
    List<CompetencesEntity> toEntities(List<CompetenceRequest> dtos);
}
