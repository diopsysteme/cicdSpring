package org.SchoolApp.Web.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.SchoolApp.Web.Validators.UniqueField;

@Data
public class PromoReferentiel {
    @UniqueField(entity = PromoReferentiel.class,field = "libelle",message = "ce promo exist deja")
    @NotNull
    @NotBlank
    private String libelle;
    @NotNull
    @NotBlank
    private String code;
    @NotNull
    @NotBlank
    private String description;

}
