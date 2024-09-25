package org.SchoolApp.Web.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.SchoolApp.Datas.Entity.CompetencesEntity;
import org.SchoolApp.Web.Validators.UniqueField;

import java.util.List;

@Data
public class CompetenceRequestDto {
    @UniqueField(field = "nom",entity = CompetencesEntity.class,message = "cette competence exist deja")
    @NotBlank
    @NotNull
    private String nom;
    @NotBlank
    @NotNull
    private String description;
    @NotNull
    @Positive
    private int dureeAcquisition;
    @NotBlank
    @NotNull
    private String type;

    private List<ModuleRequestDto> modules;
}
