package org.sir.appgestionstock.zsecurity.service.facade;

import org.sir.appgestionstock.zsecurity.entity.Role;

import java.util.List;
import java.util.Set;


public interface RoleService {
    List<Role> findAll();

    Role findByName(String name);

    Role findById(Long id);

    void deleteById(Long id);

    Role save(Role role);

    List<Role> save(List<Role> roles);

    Role update(Role role);

    int delete(Role role);

    int deleteByName(String name);

    Set<Role> findByUserName(String username);
}
