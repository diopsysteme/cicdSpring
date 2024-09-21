package org.SchoolApp.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.SchoolApp.Datas.Enums.EtatEnum;
import org.SchoolApp.Datas.Enums.StatusEnum;

import java.util.Date;
import java.util.Set;

@Data
@Entity
public class PromoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String libelle;

    private Date date_debut;
    private Date date_fin;

    private int duree;

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
