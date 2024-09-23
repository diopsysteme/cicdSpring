package org.SchoolApp.Web.Dtos.Mappers;

import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Web.Dtos.Request.ReferentielRequestDto;
import org.SchoolApp.Web.Dtos.Request.ReferentielUpdateRequestDto;  // Ajout pour la mise à jour
import org.SchoolApp.Web.Dtos.Response.ReferentielResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReferentielMapper {

    @Mapping(source = "photoCouverture", target = "photo_couverture")
    ReferentielEntity toEntity(ReferentielRequestDto referentielRequestDto);

    @Mapping(source = "photo_couverture", target = "photoCouverture")
    ReferentielResponseDto toDto(ReferentielEntity referentielEntity);

    ReferentielEntity toEntity(ReferentielUpdateRequestDto referentielUpdateRequestDto);  // Pour les mises à jour
}
