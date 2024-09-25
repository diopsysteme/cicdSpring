package org.SchoolApp.Services.Impl;

import org.SchoolApp.Datas.Entity.CompetencesEntity;
import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.StatusReferenceEnum;
import org.SchoolApp.Datas.Repository.ModulesRepository;
import org.SchoolApp.Datas.Repository.ReferentielRepository;
import org.SchoolApp.Services.Interfaces.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.SchoolApp.Datas.Repository.CompetencesRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReferentielServiceImpl implements ReferentielService {

    @Autowired
    private ReferentielRepository referentielRepository;

    @Autowired
    private CompetencesRepository competencesRepository;

    @Autowired
    private ModulesRepository modulesRepository;

    @Override
    public ReferentielEntity createReferentiel(ReferentielEntity referentiel) {
        // Ensure the competences set is initialized
        if (referentiel.getCompetences() == null) {
            referentiel.setCompetences(new HashSet<>());  // Initialize if null
        }
        handleCompetenciesAndModules(referentiel);
        return referentielRepository.save(referentiel);
    }

    @Override
    public List<ReferentielEntity> listActiveReferentiels() {
        return referentielRepository.findAll();
    }

    @Override
    public List<ReferentielEntity> listReferentielsByStatus(StatusReferenceEnum status) {
        return referentielRepository.findByStatus(status);
    }


    @Override
    public ReferentielEntity updateReferentiel(Long id, ReferentielEntity updates) {
        ReferentielEntity referentiel = referentielRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referentiel not found"));
        updateFields(referentiel, updates);
        handleCompetenciesAndModules(updates);
        return referentielRepository.save(referentiel);
    }

    @Override
    public void deleteReferentiel(Long id) {
        referentielRepository.softDelete(id);
    }

    @Override
    public List<ReferentielEntity> listArchivedReferentiels() {
        return referentielRepository.findByDeletedTrue();
    }

    @Override
    public ReferentielEntity getReferentielById(Long id) {
        return referentielRepository.findById(id).orElse(null);
    }

    @Override
    public ReferentielEntity updateReferentielWithDetails(Long id, ReferentielEntity updates) {
        ReferentielEntity existing = referentielRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referentiel not found"));
        updateFields(existing, updates);
        handleCompetenciesAndModules(existing);
        return referentielRepository.save(existing);
    }

    private void updateFields(ReferentielEntity referentiel, ReferentielEntity updates) {
        if (updates.getLibelle() != null) referentiel.setLibelle(updates.getLibelle());
        if (updates.getCode() != null) referentiel.setCode(updates.getCode());
        if (updates.getDescription() != null) referentiel.setDescription(updates.getDescription());
        if (updates.getPhotoCouverture() != null) referentiel.setPhotoCouverture(updates.getPhotoCouverture());
    }

    private void handleCompetenciesAndModules(ReferentielEntity referentiel) {
        referentiel.getCompetences().forEach(competence -> {
            if (competence.getId() == null) {
                competence.getModules().forEach(module -> {
                    if (module.getId() == null) {
                        modulesRepository.save(module);
                    }
                });
                competencesRepository.save(competence);
            }
        });
    }
}
