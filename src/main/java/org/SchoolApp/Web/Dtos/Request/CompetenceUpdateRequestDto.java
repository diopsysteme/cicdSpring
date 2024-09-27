package org.SchoolApp.Web.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.SchoolApp.Datas.Entity.CompetencesEntity;
import org.SchoolApp.Validators.UniqueField;

import java.util.List;

@Data
public class CompetenceUpdateRequestDto {
    @NotNull
    private Long id;
    @NotNull
    @NotBlank
    @UniqueField(entity = CompetencesEntity.class,field = "nom",message = "cette competence exist deja")
    private String nom;
    @NotNull
    @NotBlank
    private String description;
    @Positive
    @NotNull
    private int dureeAcquisition;
    @NotNull
    @NotBlank
    private String type;
    private boolean deleted = false;
    private List<ModuleUpdateRequestDto> modules;
}
