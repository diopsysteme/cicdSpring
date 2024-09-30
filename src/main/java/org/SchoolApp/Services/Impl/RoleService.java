package org.SchoolApp.Services.Impl;

import org.SchoolApp.Datas.Entity.Role;
import org.SchoolApp.Datas.Repository.ApprenantRepository;
import org.SchoolApp.Datas.Repository.RoleRepository;
import org.SchoolApp.Web.Dtos.Mapper.ApprenantMapper;
import org.SchoolApp.Web.Dtos.Mapper.RoleMapper;
import org.SchoolApp.Web.Dtos.Request.RoleReqDto;
import org.SchoolApp.Web.Dtos.Response.RoleResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prog.dependancy.Services.AbstractService;
@Service
public class RoleService extends AbstractService<Role, RoleReqDto, RoleResDto> {

    @Autowired
    public RoleService(RoleRepository repository, RoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public RoleResDto save(RoleReqDto roleReqDto) {
        roleReqDto.setLibelle("ROLE_"+roleReqDto.getLibelle());
        Role role = mapper.toEntity(roleReqDto);
        role = repository.save(role);
        return mapper.toDto(role);
    }
}
