package org.SchoolApp.Web.Dtos.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class NoteUpdate {
    @NotNull
    @Positive
    private Long noteId;
    @NotNull
    @Positive
    private float note;
}
