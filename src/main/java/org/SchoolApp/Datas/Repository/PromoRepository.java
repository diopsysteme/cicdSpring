package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.PromoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoRepository extends SoftDeleteRepository<PromoEntity,Long> {
}
