package org.SchoolApp.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.SchoolApp.Datas.Enums.EtatEnum;
import java.time.LocalDateTime;

import java.util.Date;
import java.util.Set;

@Data
@Entity
public class PromoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String libelle;

    private Date date_debut;
    private Date date_fin;

    private int duree;

    private boolean deleted = false;

    private LocalDateTime deletedAt;

    @Enumerated(EnumType.STRING)
    private EtatEnum etat;

    @ManyToMany
    @JoinTable(
            name = "promotion_referentiel",
            joinColumns = @JoinColumn(name = "promotion_id"),
            inverseJoinColumns = @JoinColumn(name = "referentiel_id")
    )
    private Set<ReferentielEntity> referentiels;

}
