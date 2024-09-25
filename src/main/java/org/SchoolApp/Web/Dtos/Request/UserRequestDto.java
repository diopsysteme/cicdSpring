package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

@Data
public class UserRequestDto {
    private String nom;
    private String prenom;
    private String email; // Login will be the email
    private String adresse;
}
