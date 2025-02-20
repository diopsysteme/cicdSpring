package org.SchoolApp.Datas.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;

@Data
@NoRepositoryBean
@ToString
@MappedSuperclass
@Where(clause = "deleted = false")
public abstract class EntityAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected boolean deleted = false;
    protected LocalDateTime deletedAt;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}
