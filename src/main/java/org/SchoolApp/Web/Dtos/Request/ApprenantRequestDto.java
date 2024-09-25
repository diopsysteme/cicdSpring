package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

@Data
public class ApprenantRequestDto {
    private String nomTuteur;
    private String prenomTuteur;
    private String contactTuteur;
    private String cniFile;
    private String extraitFile;
    private String diplomeFile;
    private String casierFile;
    private String photoCouverture;

    private Long referentielId;  // ID to reference ReferentielEntity
    private Long promoId;        // ID to reference PromoEntity

    private UserRequestDto user; // Data needed to create a user account
}
