package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class EtatApprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String etat;

    @Column(nullable = false)
    private String motif;

    private boolean deleted = false;

    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "etatApprenant")
    @JsonIgnore
    private List<ApprenantEntity> apprenants;
}
