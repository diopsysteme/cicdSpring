package org.SchoolApp.Web.Dtos.Response;

import lombok.*;

import java.util.Date;

@Data
public class PromoResponseDto {
    private Long id;
    private String libelle;
    private Date dateDebut;
    private Date dateFin;
    private int duree;
    private String etat;  // Status of promotion
    private String referentiel;  // Name of associated Referentiel
}
