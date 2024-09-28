package org.SchoolApp.Web.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.SchoolApp.Datas.Entity.CompetencesEntity;
import org.SchoolApp.Validators.UniqueField;

@Data
public class CompetenceRequest {
    @UniqueField(field = "nom",entity = CompetencesEntity.class,message = "cette competence exist deja")
    @NotBlank
    @NotNull
    private String nom;
    @Positive
    @NotNull
    private int dureeAcquisition;
    @NotBlank
    @NotNull
    private String description;
    @NotBlank
    @NotNull
    private String type;

}
