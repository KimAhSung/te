package com.skcc.b2bcrm.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@Data
//@NoArgsConstructor
public class Menu {

    @Id
    private String id;
    private String name;
    private String createdDate;
    private String changedDate;

//    @OneToMany(mappedBy = "menu")
//    private List<RoleMenuMapping> roles;

}
