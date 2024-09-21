package org.SchoolApp.Services.Interfaces;

import org.SchoolApp.Datas.Entity.CompetencesEntity;
import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.StatusReferenceEnum;

import java.util.List;

public interface ReferentielService {

    List<ReferentielEntity> getAllReferentiels();

    List<ReferentielEntity> getActiveReferentiels();  // Référentiels actifs

    List<ReferentielEntity> getDeletedReferentiels(); // Référentiels supprimés

    List<ReferentielEntity> getReferentielsByStatus(StatusReferenceEnum status);

    ReferentielEntity getReferentielById(Long id);

    ReferentielEntity createReferentiel(ReferentielEntity referentiel, List<CompetencesEntity> competences); // Création avec compétences

    ReferentielEntity updateReferentiel(Long id, ReferentielEntity referentiel);

    void deleteReferentiel(Long id);

    List<CompetencesEntity> getCompetencesWithModulesByReferentiel(Long referentielId);

    List<ModulesEntity> getModulesByReferentiel(Long referentielId);

    CompetencesEntity addCompetenceToReferentiel(Long referentielId, CompetencesEntity competence);

    ModulesEntity addModuleToCompetence(Long referentielId, Long competenceId, ModulesEntity module);

    void deleteCompetenceFromReferentiel(Long referentielId, Long competenceId);

    void deleteModuleFromCompetence(Long referentielId, Long competenceId, Long moduleId);
}
