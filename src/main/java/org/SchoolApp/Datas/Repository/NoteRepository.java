package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.NotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends SoftDeleteRepository<NotesEntity, Long> {
}
