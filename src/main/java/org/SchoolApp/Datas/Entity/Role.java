package Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String libelle;

    @OneToMany(mappedBy = "role")
    private List<UserEntity> users;
}
