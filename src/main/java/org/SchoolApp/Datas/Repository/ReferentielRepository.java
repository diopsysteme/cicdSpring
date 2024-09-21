package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferentielRepository extends SoftDeleteRepository<ReferentielEntity,Long> {
}
