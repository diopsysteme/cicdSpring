package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.PromoEntity;
import org.springframework.data.jpa.repository.Query;

public interface PromoRepository extends SoftDeleteRepository<PromoEntity,Long> {
    @Query("SELECT p FROM PromoEntity p WHERE p.etat = 'ACTIF'")
    PromoEntity findActivePromo();
}
