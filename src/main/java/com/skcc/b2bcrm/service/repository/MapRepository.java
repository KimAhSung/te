package com.skcc.b2bcrm.service.repository;

import com.skcc.b2bcrm.service.model.Role;
import com.skcc.b2bcrm.service.model.RoleMenuMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MapRepository extends JpaRepository<RoleMenuMapping, String>{
    @Query("select distinct rm from test rm"+
            " join fetch rm.role r")
    public List<RoleMenuMapping> findMappingAll();


}
