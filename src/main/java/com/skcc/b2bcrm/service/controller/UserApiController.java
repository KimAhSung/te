package com.skcc.b2bcrm.service.controller;
import com.skcc.b2bcrm.service.model.Role;
import com.skcc.b2bcrm.service.model.User;
import com.skcc.b2bcrm.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
class UserApiController {

    @Autowired
    private UserRepository repository;

    UserApiController(UserRepository repository){this.repository = repository;}


    @GetMapping("/users")
    List<User> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text) {
        List<User> users = null;
        users = repository.findAll();
        return users;
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/users/{id}")
    User one(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable String id) {

        return repository.findById(id)
                .map(user -> {
//                    user.setTitle(newUser.getTitle());
//                    user.setContent(newUser.getContent());
//                    user.setBoards(newUser.getBoards());
                    user.getRoles().clear();
                    user.getRoles().addAll(newUser.getRoles());
                    for(Role role : user.getRoles()) {
                        role.setUsers((List<User>) user);
                    }
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });

    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable String id) {
        repository.deleteById(id);
    }
}