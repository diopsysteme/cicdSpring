package org.SchoolApp.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class NotesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float note;

    private boolean deleted = false;

    private LocalDateTime deletedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id", nullable = false)
    private ModulesEntity module;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apprenant_id", nullable = false)
    private ApprenantEntity apprenant;
}
