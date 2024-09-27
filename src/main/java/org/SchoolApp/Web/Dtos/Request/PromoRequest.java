package org.SchoolApp.Web.Dtos.Request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.SchoolApp.Datas.Entity.PromoEntity;
import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.EtatEnum;
import org.SchoolApp.Validators.UniqueField;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Data
public class PromoRequest {
    @NotBlank
    @NotNull
    @UniqueField(entity = PromoEntity.class,field = "libelle")
    private String libelle;

    @NotNull
    private Date dateDebut;
    @NotNull
    @Future
    private Date dateFin;
    @NotNull
    private boolean deleted;
    @NotNull
    @Positive
    private int duree;
    @NotNull
    private EtatEnum etat;
    private Set<ReferentielDto> referentiels;
}
