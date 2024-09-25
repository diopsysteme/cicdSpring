package org.SchoolApp.Web.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.SchoolApp.Web.Validators.UniqueField;

@Data
public class ModuleRequestDto {
    @UniqueField(entity = ModulesEntity.class,field = "nom",message = "ce module exist deja")
    @NotBlank
    @NotNull
    private String nom;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @Positive
    private int duree_acquisition;
}
