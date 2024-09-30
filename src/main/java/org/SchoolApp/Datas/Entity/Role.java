package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import prog.dependancy.Datas.Entity.EntityAbstract;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@ToString
public class Role extends EntityAbstract {

    private String libelle;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    @ToString.Exclude
    private List<UserEntity> users;
}
