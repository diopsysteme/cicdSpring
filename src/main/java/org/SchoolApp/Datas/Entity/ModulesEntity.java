package Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ModulesEntity {
    @Id
    @GeneratedValue
    private int id;

    private String nom;

    private String description;

    private int duree_acquisition;

    @ManyToMany(mappedBy = "modules")
    private List<CompetencesEntity> competences;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    private List<NotesEntity> notes;
}
