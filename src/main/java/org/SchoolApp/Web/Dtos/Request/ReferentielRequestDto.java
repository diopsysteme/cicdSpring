package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;
import java.util.List;

@Data
public class ReferentielRequestDto {
    private String libelle;
    private String code;
    private String description;
    private String photoCouverture;  // Use camelCase to match the entity
    private List<CompetenceRequestDto> competences;
}
