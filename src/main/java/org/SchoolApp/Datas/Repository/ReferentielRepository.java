package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.StatusReferenceEnum;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferentielRepository extends SoftDeleteRepository<ReferentielEntity, Long> {
    // Fetch referentials by their status (e.g., Actif, Inactif)
    List<ReferentielEntity> findByStatus(StatusReferenceEnum status);

    // Fetch archived referentials (soft deleted)
    List<ReferentielEntity> findByDeletedTrue();
}
