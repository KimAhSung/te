package com.skcc.b2bcrm.service.controller;
import com.skcc.b2bcrm.service.exception.NotFoundException;
import com.skcc.b2bcrm.service.model.Role;
import com.skcc.b2bcrm.service.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
class RoleApiController {

    private final RoleRepository roleRepository;


    @GetMapping("/")
    List<Role> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text) {
        List<Role> role = roleRepository.findAll();

//        role= roleRepository.findByRoleAll();


        return role;
    }

    @PostMapping("/")
    Role newRole(@RequestBody Role newRole) {
        String localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        newRole.setChangedDate(localDate);
        newRole.setCreatedDate(localDate);
        return roleRepository.save(newRole);
    }

    // Single item

    @GetMapping("/{id}")
    Role one(@PathVariable String id) {

        return roleRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @PutMapping("/{id}")
    Role replaceRole(@RequestBody Role newRole, @PathVariable String id) {
        String localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Role role = roleRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        role.setName(newRole.getName());
        role.setChangedDate(localDate);
        return roleRepository.save(role);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable String id) {
        roleRepository.deleteById(id);
    }
}