package org.sir.appgestionstock.zsecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.sir.appgestionstock.zutils.entity.BaseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<AppUser> users = new ArrayList<>();

    @ManyToMany()
    @JoinTable(
            name = "roles_permissions",
            joinColumns = {@JoinColumn(name = "role")},
            inverseJoinColumns = {@JoinColumn(name = "permission")}
    )
    private Set<Permission> permissions = new HashSet<>();
    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
