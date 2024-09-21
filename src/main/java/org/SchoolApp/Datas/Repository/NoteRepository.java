package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.ApprenantEntity;
import org.SchoolApp.Datas.Entity.NotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends SoftDeleteRepository<NotesEntity, Long> {
    List<NotesEntity> findByApprenant(ApprenantEntity apprenant);
    List<NotesEntity> findByApprenantAndModule(ApprenantEntity apprenant, Module module);
}
