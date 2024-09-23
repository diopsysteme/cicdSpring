package org.SchoolApp.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@ToString
public class Fonction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean deleted = false;

    private LocalDateTime deletedAt;

    private String libelle;

    private String description;

    @OneToMany(mappedBy = "fonction")
    @ToString.Exclude
    private List<UserEntity> users;
}
