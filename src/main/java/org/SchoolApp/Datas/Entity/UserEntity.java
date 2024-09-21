package Datas.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String adresse;

    @Column(unique = true, nullable = false)
    private String Telephone;

    @Column(nullable = true)
    private int fonction_id;

    private int role_id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private String status;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "fonction_id", nullable = true)
    private Fonction fonction;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ApprenantEntity apprenant;

    @ManyToMany
    @JoinTable(
            name = "user_emargement",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "emargement_id")
    )
    private Set<EmargementEntity> emargements;
}
