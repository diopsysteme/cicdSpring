package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Datas.Entity.ApprenantEntity;
import org.SchoolApp.Web.Dtos.Request.ApprenantRequestDto;
import org.SchoolApp.Web.Dtos.Response.ApprenantResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ReferentielMapper.class, PromoMapper.class})
public interface ApprenantMapper {

    ApprenantEntity toEntity(ApprenantRequestDto dto);

    ApprenantResponseDto toDto(ApprenantEntity entity);
}
