package org.SchoolApp.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.SchoolApp.Datas.Enums.StatusReferenceEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class ReferentielEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String libelle;

    @Column(nullable = false, unique = true)
    private String code;

    private String description;

    private boolean deleted = false;

    private LocalDateTime deletedAt;

    private String photo_couverture;

    @Enumerated(EnumType.STRING)
    private StatusReferenceEnum status;

    @ManyToMany(mappedBy = "referentiels")
    private List<PromoEntity> promos;

    @OneToMany(mappedBy = "referentiel")
    private Set<ApprenantEntity> apprenants;

    @ManyToMany
    @JoinTable(
            name = "referentiel_competence",
            joinColumns = @JoinColumn(name = "referentiel_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    private Set<CompetencesEntity> competences;

}