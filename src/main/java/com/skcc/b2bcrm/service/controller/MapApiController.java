package com.skcc.b2bcrm.service.controller;
import com.skcc.b2bcrm.service.exception.NotFoundException;
import com.skcc.b2bcrm.service.model.Menu;
import com.skcc.b2bcrm.service.model.Role;
import com.skcc.b2bcrm.service.model.RoleMenuMapping;
import com.skcc.b2bcrm.service.repository.MapRepository;
import com.skcc.b2bcrm.service.repository.MenuRepository;
import com.skcc.b2bcrm.service.repository.RoleRepository;
import com.skcc.b2bcrm.service.service.MapService;
import com.skcc.b2bcrm.service.service.RoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
class MapApiController {

    private final MapRepository mapRepository;
    private final RoleRepository roleRepository;
    private final MenuRepository menuRepository;
    private MapService mapService;


    @GetMapping("/map/")
    List<RoleMenuMapping> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text) {
        List<RoleMenuMapping> list = mapRepository.findAll();

//        List<RoleDTO> roleList = list.stream()
//                .map(r -> new RoleDTO(r.getRole()))
//                .collect(Collectors.toList());

        return list;

    }

    @PostMapping("/map/")
    RoleMenuMapping newMap(@RequestBody RoleMenuMapping newMap) {
//        String localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("test1 : "+newMap.getMenu());
        System.out.println("test2 : "+newMap.getRole());
        String localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Role role = roleRepository.findById(newMap.getRole().getId()).orElseThrow(() -> new NotFoundException(newMap.getRole().getId()));
        Menu menu = menuRepository.findById(newMap.getMenu().getId()).orElseThrow(() -> new NotFoundException(newMap.getMenu().getId()));

        System.out.println("test3 : "+role);
        System.out.println("test4 : "+menu);

        newMap.setMenu(menu);
        newMap.setRole(role);
        newMap.setCreatedDate(localDate);
        newMap.setChangedDate(localDate);
//        mapRepository.save(newMap);
        return mapRepository.save(newMap);

//        mapService.save(newMap);
//        return mapService.save(newMap);

    }

    // Single item

    @GetMapping("/map/{id}")
    Role one(@PathVariable String id) {
        return  roleRepository.findById(id).orElseThrow(() ->new NotFoundException(id));




    }

    @PutMapping("/map/{id}")
    RoleMenuMapping replaceMap(@RequestBody RoleMenuMapping newMap, @PathVariable String id) {


        return null;
    }

    @DeleteMapping("/map/{id}")
    void deleteMap(@PathVariable String id) {
        mapRepository.deleteById(id);
    }
}