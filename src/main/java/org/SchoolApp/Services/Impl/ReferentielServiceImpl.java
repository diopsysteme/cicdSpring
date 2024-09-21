package org.SchoolApp.Services.Impl;

import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.StatusReferenceEnum;
import org.SchoolApp.Services.Interfaces.ReferentielService;
import org.SchoolApp.Datas.Repository.ReferentielRepository;
import org.SchoolApp.Datas.Repository.SoftDeleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferentielServiceImpl implements ReferentielService {

    @Autowired
    private ReferentielRepository referentielRepository;

    @Autowired
    private SoftDeleteRepository<ReferentielEntity, Long> softDeleteRepository;

    @Override
    public List<ReferentielEntity> getAllReferentiels() {
        return referentielRepository.findAll();
    }

    @Override
    public List<ReferentielEntity> getActiveReferentiels() {
        return referentielRepository.findByStatus(StatusReferenceEnum.Actif);
    }

    @Override
    public List<ReferentielEntity> getDeletedReferentiels() {
        return referentielRepository.findByDeletedTrue();
    }

    @Override
    public List<ReferentielEntity> getReferentielsByStatus(StatusReferenceEnum status) {
        return referentielRepository.findByStatus(status);
    }

    @Override
    public ReferentielEntity getReferentielById(Long id) {
        return referentielRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referentiel not found"));
    }

    @Override
    public ReferentielEntity createReferentiel(ReferentielEntity referentiel) {
        return referentielRepository.save(referentiel);
    }

    @Override
    public ReferentielEntity updateReferentiel(Long id, ReferentielEntity referentiel) {
        ReferentielEntity existingReferentiel = referentielRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referentiel not found"));
        existingReferentiel.setLibelle(referentiel.getLibelle());
        existingReferentiel.setCode(referentiel.getCode());
        existingReferentiel.setDescription(referentiel.getDescription());
        existingReferentiel.setPhoto_couverture(referentiel.getPhoto_couverture());
        existingReferentiel.setStatus(referentiel.getStatus());  // Mettre à jour le statut
        return referentielRepository.save(existingReferentiel);
    }

    @Override
    public void deleteReferentiel(Long id) {
        // Vérifier si le référentiel est utilisé dans une promotion en cours
        if (referentielRepository.existsByIdAndPromos_EncoursTrue(id)) {
            throw new RuntimeException("Cannot delete a referentiel used in an active promotion");
        }

        // Si pas utilisé, effectuer un soft delete
        softDeleteRepository.softDelete(id);
    }
}
