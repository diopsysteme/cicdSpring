package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

@Data
public class UserRequestDto {
    private String email;             // Required
    private String password;          // Required
    private String nom;               // Required
    private String prenom;            // Optional
    private String adresse;           // Optional
    private String telephone;         // Required
    private String photo;             // Optional
    private Long roleId;
}
