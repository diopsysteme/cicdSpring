package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;
import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Web.Validators.UniqueField;

import java.util.List;

@Data
public class ReferentielUpdateRequestDto {
    @UniqueField(entity = ReferentielEntity.class,field = "libelle",message = "exist deja")
    private String libelle;
    private String description;
    private List<CompetenceUpdateRequestDto> competences;
}
