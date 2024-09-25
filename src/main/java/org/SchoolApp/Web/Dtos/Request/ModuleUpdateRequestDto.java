package org.SchoolApp.Web.Dtos.Request;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.SchoolApp.Web.Validators.UniqueField;

@Data
public class ModuleUpdateRequestDto {
    private Long id;
    @UniqueField(entity = ModulesEntity.class,field = "nom",message = "ce module exist deja")
    private String nom;
    private String description;
    @Positive
    private int dureeAcquisition;
    private boolean deleted = false;
}
