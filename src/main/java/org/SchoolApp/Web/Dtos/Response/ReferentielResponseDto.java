package org.SchoolApp.Web.Dtos.Response;

import lombok.Data;
import java.util.List;

@Data
public class ReferentielResponseDto {
    private Long id;
    private String libelle;
    private String code;
    private String description;
    private String photoCouverture;  // Keep camelCase consistent
    private String status;  // Map status as a string
    private List<CompetenceResponseDto> competences;  // List of competence DTOs
}
