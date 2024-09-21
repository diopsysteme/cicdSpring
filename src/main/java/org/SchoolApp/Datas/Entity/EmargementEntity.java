package org.SchoolApp.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class EmargementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean deleted = false;

    private LocalDateTime deletedAt;

    private Date entree;
    private Date sortie;

    @ManyToMany(mappedBy = "emargements")
    private Set<UserEntity> users;
}
