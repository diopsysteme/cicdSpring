package org.SchoolApp.Datas.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoRepositoryBean
public interface SoftDeleteRepository<T,ID> extends JpaRepository<T, ID> {
    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.deleted = true, e.deletedAt = CURRENT_TIMESTAMP WHERE e.id = ?1")
    void softDelete(Long id);
    @Query("SELECT e FROM #{#entityName} e WHERE e.deleted = false")
    List<T> findAll();
}
