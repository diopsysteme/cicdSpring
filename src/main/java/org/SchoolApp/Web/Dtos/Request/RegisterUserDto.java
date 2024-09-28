    package org.SchoolApp.Web.Dtos.Request;

    import lombok.Builder;
    import lombok.Data;
    @Builder
    @Data
    public class RegisterUserDto {
        private String email;             // Required
        private String password;          // Required
        private String nom;               // Required
        private String prenom;            // Optional
        private String adresse;           // Optional
        private String telephone;         // Required
        private String photo;             // Optional
        private Long roleId;              // Required, as a Long for the role ID
    }

