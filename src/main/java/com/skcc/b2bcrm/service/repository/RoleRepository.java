package com.skcc.b2bcrm.service.repository;

import com.skcc.b2bcrm.service.model.Role;
import com.skcc.b2bcrm.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, String>{
    @Query("select distinct r from Role r join fetch r.menus")
    public List<Role> findByRoleAll();
}
