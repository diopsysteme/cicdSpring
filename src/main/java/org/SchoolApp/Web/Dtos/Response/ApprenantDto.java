package org.SchoolApp.Web.Dtos.Response;

import lombok.Data;
import org.SchoolApp.Web.Dtos.BaseDto;
@Data
public class ApprenantDto extends BaseDto {
    private String nomTuteur;
    private String prenomTuteur;
    private String contactTuteur;
    private String matricule;
    private String qrCodeLink;

    private UserResponseDto user;
    private String referentiel;
    private String promo;;
}
