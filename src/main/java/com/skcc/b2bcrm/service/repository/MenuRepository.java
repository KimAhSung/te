package com.skcc.b2bcrm.service.repository;

import com.skcc.b2bcrm.service.model.Menu;
import com.skcc.b2bcrm.service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, String>{
//    @Query("select distinct r from Role r join fetch r.menus")
//    public List<Role> findByRoleAll();
}
