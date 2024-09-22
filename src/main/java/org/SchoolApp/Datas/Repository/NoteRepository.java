package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.ApprenantEntity;
import org.SchoolApp.Datas.Entity.NotesEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends SoftDeleteRepository<NotesEntity, Long> {
    List<NotesEntity> findByApprenant(ApprenantEntity apprenant);
    List<NotesEntity> findByApprenantAndModule(ApprenantEntity apprenant, Module module);
}
