package Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class EtatApprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String etat;

    @Column(nullable = false)
    private String motif;

    @OneToMany(mappedBy = "etatApprenant")
    private List<ApprenantEntity> apprenants;
}
