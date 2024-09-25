package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Datas.Entity.PromoEntity;
import org.SchoolApp.Web.Dtos.Request.PromoRequestDto;
import org.SchoolApp.Web.Dtos.Response.PromoResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromoMapper {

    // Mapping from request DTO to entity
    PromoEntity toEntity(PromoRequestDto dto);

    // Mapping from entity to response DTO
    PromoResponseDto toDto(PromoEntity entity);
}
