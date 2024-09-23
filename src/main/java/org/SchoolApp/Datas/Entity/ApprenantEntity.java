package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@ToString
public class ApprenantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom_tuteur;
    private String prenom_tuteur;
    private String contact_tuteur;
    private String cni_file;
    private String extrait_file;
    private String diplome_file;
    private String casier_file;
    private String photo_couverture;

    private boolean deleted = false;
    private LocalDateTime deletedAt;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_id", nullable = true)
    @JsonIgnore
    @ToString.Exclude
    private EtatApprenant etatApprenant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referentiel_id", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private ReferentielEntity referentiel;

    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore // This prevents recursion by marking the back reference
    @ToString.Exclude
    private List<NotesEntity> notes;
}
