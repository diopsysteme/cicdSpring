package org.SchoolApp.Web.Dtos.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class NoteRequest {
    @Positive
    @NotNull
    private float note;
    @NotNull
    @Positive
    private Long apprenant;
    @NotNull
    @Positive
    private Long module;
}
