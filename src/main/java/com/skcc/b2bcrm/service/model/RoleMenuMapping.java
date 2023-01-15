package com.skcc.b2bcrm.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "test")
@Getter
@Setter
@Table(name ="test")
//public class RoleMenuMapping {
public class RoleMenuMapping implements Serializable {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonIgnore
    private Role role;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    private String createdDate;
    private String changedDate;



//    public RoleMenuMapping(Role role, Menu menu, String createdDate, String changedDate) {
//        this.role = role;
//        this.menu = menu;
//        this.createdDate = createdDate;
//        this.changedDate = changedDate;
//    }
}
