package org.SchoolApp.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class ModulesEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String description;

    private int duree_acquisition;

    private boolean deleted = false;

    private LocalDateTime deletedAt;

    @ManyToMany(mappedBy = "modules")
    private List<CompetencesEntity> competences;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NotesEntity> notes;
}
