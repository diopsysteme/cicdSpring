package org.SchoolApp.Datas.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.SchoolApp.Datas.Enums.StatusEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Data
@Entity
@ToString
public class UserEntity extends EntityAbstract implements UserDetails {

    private String nom;
    private String prenom;
    private String adresse;
    @Column(unique = true, nullable = false)
    private String telephone;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    private String photo;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = true)
    @JsonIgnore
    @ToString.Exclude
    private Role role;
    @ManyToOne
    @JoinColumn(name = "fonction_id", nullable = true)
    @JsonIgnore
    @ToString.Exclude
    private Fonction fonction;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private ApprenantEntity apprenant;
    @ManyToMany
    @JoinTable(
            name = "user_emargement",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "emargement_id")
    )
    @JsonIgnore
    private Set<EmargementEntity> emargements;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserEntity other = (UserEntity) obj;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return 31; // or use a constant or just return a unique identifier hash
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert the Role object to a SimpleGrantedAuthority and wrap it in a list
        return Collections.singletonList(new SimpleGrantedAuthority(role.getLibelle()));
    }

    @Override
    public String getUsername() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true; // Adjust this based on your logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Adjust this based on your logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Adjust this based on your logic
    }

    @Override
    public boolean isEnabled() {
        return status == StatusEnum.ACTIF; // Example check for enabled status
    }
}
