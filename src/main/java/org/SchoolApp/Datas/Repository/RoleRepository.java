package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prog.dependancy.Datas.Repository.SoftDeleteRepository;

@Repository
public interface RoleRepository extends SoftDeleteRepository<Role, Long> {
    // Recherche un rôle par son libellé (ex : "Admin", "Manager", etc.)
    Role findByLibelle(String libelle);
}

