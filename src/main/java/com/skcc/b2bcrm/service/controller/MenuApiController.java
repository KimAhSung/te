package com.skcc.b2bcrm.service.controller;
import com.skcc.b2bcrm.service.exception.NotFoundException;
import com.skcc.b2bcrm.service.model.Menu;
import com.skcc.b2bcrm.service.model.Role;
import com.skcc.b2bcrm.service.repository.MenuRepository;
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
class MenuApiController {


    private final MenuRepository menuRepository;



    @GetMapping("/menu/")
    List<Menu> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text) {
        List<Menu> menus = menuRepository.findAll();
        return menus;
    }

    @PostMapping("/menu")
    Menu newMenu(@RequestBody Menu newMenu) {
        String localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        newMenu.setChangedDate(localDate);
        newMenu.setCreatedDate(localDate);
        return menuRepository.save(newMenu);
    }

    // Single item

    @GetMapping("/menu/{id}")
    Menu one(@PathVariable String id) {

        return menuRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @PutMapping("/menu/{id}")
    Menu replaceMenu(@RequestBody Menu newMenu, @PathVariable String id) {
        String localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Menu menu =  menuRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

        menu.setName(newMenu.getName());
        menu.setChangedDate(localDate);
        return menuRepository.save(menu);
    }

    @DeleteMapping("/menu/{id}")
    void deleteMenu(@PathVariable String id) {
        menuRepository.deleteById(id);
    }
}