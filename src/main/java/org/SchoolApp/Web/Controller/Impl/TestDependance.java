package org.SchoolApp.Web.Controller.Impl;

import org.SchoolApp.Datas.Entity.ApprenantEntity;
import org.SchoolApp.Services.Interfaces.ApprenantService;
import org.SchoolApp.Web.Dtos.Request.ApprenantRequestDto;
import org.SchoolApp.Web.Dtos.Response.ApprenantDto;
import org.SchoolApp.Web.Dtos.Response.ApprenantResponseDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prog.dependancy.Services.AbstractService;
import prog.dependancy.Web.Controller.AbstractController;

@RestController
@RequestMapping("/test-avec-apprenant")
public class TestDependance extends AbstractController<ApprenantEntity, ApprenantRequestDto, ApprenantResponseDto> {

    public TestDependance(AbstractService<ApprenantEntity, ApprenantRequestDto ,ApprenantResponseDto> service) {
        super(service);
    }

}
