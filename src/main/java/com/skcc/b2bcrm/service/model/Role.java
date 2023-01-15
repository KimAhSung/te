package com.skcc.b2bcrm.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
//@NoArgsConstructor
public class Role {
    @Id
    private String id;

    private String name;
    private String createdDate;
    private String changedDate;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "role")
    private List<RoleMenuMapping> menus;


//    public void addMenu(RoleMenuMapping menu){menus.add(menu);}

//    public Role(String id, String name, String createdDate, String changedDate, List<RoleMenuMapping> menus) {
//        this.id = id;
//        this.name = name;
//        this.createdDate = createdDate;
//        this.changedDate = changedDate;
//        this.menus = menus;
//    }
}
