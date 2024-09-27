package org.SchoolApp.Web.Dtos.Response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.SchoolApp.Web.Dtos.BaseDto;

import java.util.List;
@Getter
@Setter
public class CompetenceResponseDto extends BaseDto {
    private String nom;
    private String description;
    private int dureeAcquisition;
    private String type;
    private List<ModuleResponseDto> modules;
}
