package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

import java.util.Date;

@Data
public class PromoRequestDto {
    private String libelle;
    private Date dateDebut;
    private Date dateFin;
    private int duree;
    private String etat;  // Status of promotion as string (can be an enum)
    private Long referentielId;  // Reference to the associated Referentiel
}
