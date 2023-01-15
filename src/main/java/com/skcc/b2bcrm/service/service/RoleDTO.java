package com.skcc.b2bcrm.service.service;

import com.skcc.b2bcrm.service.model.Role;
import lombok.Data;

@Data
public class RoleDTO {

    private String id;
    private String name;

    public RoleDTO(Role role){
        id = role.getId();
        name = role.getName();
    }
}
