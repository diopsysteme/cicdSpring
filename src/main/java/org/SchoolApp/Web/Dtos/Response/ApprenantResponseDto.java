package org.SchoolApp.Web.Dtos.Response;

import lombok.Data;

@Data
public class ApprenantResponseDto {
    private Long id;
    private String nomTuteur;
    private String prenomTuteur;
    private String contactTuteur;
    private String matricule;
    private String qrCodeLink;

    private UserResponseDto user;
    private ReferentielResponseDto referentiel;
    private PromoResponseDto promo;
}
