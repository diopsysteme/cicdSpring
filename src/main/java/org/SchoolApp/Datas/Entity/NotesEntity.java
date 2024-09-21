package org.SchoolApp.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class NotesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float note;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private ModulesEntity module;

    @ManyToOne
    @JoinColumn(name = "apprenant_id", nullable = false)
    private ApprenantEntity apprenant;
}
