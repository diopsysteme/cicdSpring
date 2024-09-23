package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class EmargementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Soft delete fields
    private boolean deleted = false;
    private Date deletedAt; // This field is necessary for the soft delete logic

    // Date and time fields
    private LocalDate date;  // Date for emargement
    private LocalTime entree; // Entry time
    private LocalTime sortie; // Exit time

    // Change relationship to ManyToOne if each emargement is for a single user
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity user;  // Assuming each emargement is for one user
}
