package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.SchoolApp.Datas.Enums.EtatEnum;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Where(clause = "deleted = false")
public class PromoEntity extends EntityAbstract{

    @Column(nullable = false,unique = true)
    private String libelle;

    private Date date_debut;
    private Date date_fin;

    private int duree;

    @Enumerated(EnumType.STRING)
    private EtatEnum etat;

    @ManyToMany
    @JsonManagedReference
    @JsonIgnore
    @JoinTable(
            name = "promotion_referentiel",
            joinColumns = @JoinColumn(name = "promotion_id"),
            inverseJoinColumns = @JoinColumn(name = "referentiel_id")
    )
    private Set<ReferentielEntity> referentiels = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PromoEntity other = (PromoEntity) obj;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return 31; // or use a constant or just return a unique identifier hash
    }
}
