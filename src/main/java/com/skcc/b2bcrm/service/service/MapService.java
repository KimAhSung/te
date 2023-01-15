package com.skcc.b2bcrm.service.service;

import com.skcc.b2bcrm.service.exception.NotFoundException;
import com.skcc.b2bcrm.service.model.Menu;
import com.skcc.b2bcrm.service.model.Role;
import com.skcc.b2bcrm.service.model.RoleMenuMapping;
import com.skcc.b2bcrm.service.repository.MapRepository;
import com.skcc.b2bcrm.service.repository.MenuRepository;
import com.skcc.b2bcrm.service.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
public class MapService {

    private final RoleRepository roleRepository;
    private final MenuRepository menuRepository;
    private final MapRepository mapRepository;

    public RoleMenuMapping save(RoleMenuMapping newMap){
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
        //------------------------------------


    }
}
