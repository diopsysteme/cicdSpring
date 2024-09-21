package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.StatusReferenceEnum;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferentielRepository extends SoftDeleteRepository<ReferentielEntity, Long> {

    // Lister tous les référentiels actifs (status = Actif)
    List<ReferentielEntity> findByStatus(StatusReferenceEnum status);

    // Lister tous les référentiels non supprimés (deleted = false)
    List<ReferentielEntity> findByDeletedFalse();

    // Lister tous les référentiels supprimés (deleted = true)
    List<ReferentielEntity> findByDeletedTrue();

    // Vérifier si le référentiel est utilisé dans une promotion en cours
    boolean existsByIdAndPromos_EncoursTrue(Long id);
}
