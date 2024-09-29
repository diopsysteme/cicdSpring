package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.ApprenantEntity;
import org.SchoolApp.Datas.Entity.PromoEntity;
import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.EtatEnum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import prog.dependancy.Datas.Repository.SoftDeleteRepository;

import java.util.List;
@Repository
public interface ApprenantRepository  extends SoftDeleteRepository<ApprenantEntity,Long> {
    @Query("SELECT a FROM ApprenantEntity a " +
            "JOIN a.referentiel r " +
            "JOIN r.promos p " +
            "WHERE p.etat = 'ACTIVE' AND p.deleted = false AND r.id = :referentielId")
    List<ApprenantEntity> findApprenantsByReferentielAndActivePromo(@Param("referentielId") Long referentielId);

    @Query("SELECT a FROM ApprenantEntity a " +
            "JOIN a.referentiel r " +
            "JOIN r.promos p " +
            "WHERE p.etat = 'ACTIVE' AND p.deleted = false")
    List<ApprenantEntity> findApprenantsByActivePromo();

    @Query("SELECT a FROM ApprenantEntity a " +
            "JOIN a.referentiel r " +
            "JOIN r.promos p " +
            "WHERE p.id = :promoId AND p.deleted = false")
    List<ApprenantEntity> findApprenantsByPromoId(@Param("promoId") Long promoId);
    @Query("SELECT a FROM ApprenantEntity a " +
            "JOIN a.referentiel r " +
            "JOIN r.promos p " +
            "WHERE p.id = :promoId AND r.id = :referentielId AND p.deleted = false")
    List<ApprenantEntity> findApprenantsByPromoIdAndReferentielId(@Param("promoId") Long promoId, @Param("referentielId") Long referentielId);
    // Trouver tous les apprenants d'une promo donnée par son ID
    List<ApprenantEntity> findByPromo(PromoEntity promo);

    // Trouver tous les apprenants d'une promo active
    List<ApprenantEntity> findByPromo_Etat(EtatEnum etat);

    // Trouver tous les apprenants d'une promo active filtrés par référentiel ID
    List<ApprenantEntity> findByPromo_EtatAndReferentiel_Id(EtatEnum etat, Long referentielId);

    // Trouver tous les apprenants d'un référentiel donné et d'une promo par ID
    List<ApprenantEntity> findByReferentiel_IdAndPromo_Id(Long referentielId, Long promoId);
}
