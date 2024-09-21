package Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Fonction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String libelle;

    private String description;

    @OneToMany(mappedBy = "fonction")
    private List<UserEntity> users;
}
