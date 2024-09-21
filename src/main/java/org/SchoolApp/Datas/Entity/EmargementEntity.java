package org.SchoolApp.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
public class EmargementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date entree;
    private Date sortie;

    @ManyToMany(mappedBy = "emargements")
    private Set<UserEntity> users;
}
