package org.SchoolApp.Services.Interfaces;

import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.StatusReferenceEnum;

import java.util.List;

public interface ReferentielService {

    List<ReferentielEntity> getAllReferentiels();

    // Référentiels actifs
    List<ReferentielEntity> getActiveReferentiels();

    // Référentiels supprimés
    List<ReferentielEntity> getDeletedReferentiels();

    // Filtrer les référentiels par statut
    List<ReferentielEntity> getReferentielsByStatus(StatusReferenceEnum status);

    ReferentielEntity getReferentielById(Long id);

    ReferentielEntity createReferentiel(ReferentielEntity referentiel);

    ReferentielEntity updateReferentiel(Long id, ReferentielEntity referentiel);

    void deleteReferentiel(Long id);  // Suppression douce avec vérification des promotions en cours
}
