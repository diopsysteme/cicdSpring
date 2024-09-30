package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;
import org.SchoolApp.Datas.Entity.PromoEntity;
import org.SchoolApp.Datas.Entity.Role;
import org.SchoolApp.Validators.UniqueField;

@Data
public class RoleReqDto {
    @UniqueField(entity = Role.class,field = "libelle",message = "ce role existe deja")
    private String libelle;
}
