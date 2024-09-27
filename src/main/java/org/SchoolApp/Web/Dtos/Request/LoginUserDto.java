package org.SchoolApp.Web.Dtos.Request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserDto {
    private String email;
    private String password;
}
