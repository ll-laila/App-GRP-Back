package org.sir.appgestionstock.zsecurity.service.impl;

import org.sir.appgestionstock.zsecurity.entity.Permission;
import org.sir.appgestionstock.zsecurity.entity.Role;
import org.sir.appgestionstock.zsecurity.dao.RoleDao;
import org.sir.appgestionstock.zsecurity.service.facade.PermissionService;
import org.sir.appgestionstock.zsecurity.service.facade.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;
    private final PermissionService permissionService;

    public RoleServiceImpl(RoleDao roleDao, PermissionService permissionService) {
        this.roleDao = roleDao;
        this.permissionService = permissionService;
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findByName(String name) {
        if (name == null) return null;
        return roleDao.findByName(name);
    }

    @Override
    @Transactional
    public int deleteByName(String name) {
        return roleDao.deleteByName(name);
    }

    @Override
    public Role findById(Long id) {
        return roleDao.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        roleDao.deleteById(id);
    }

    @Override
    public List<Role> save(List<Role> roles) {
        List<Role> result = new ArrayList<>();
        roles.forEach(role -> result.add(save(role)));
        return result;
    }

    @Override
    public Role update(Role role) {
        Role foundedRole = findById(role.getId());
        if (foundedRole == null) return null;
        return roleDao.save(role);
    }

    @Override
    @Transactional
    public int delete(Role role) {
        if (role.getName() == null) return -1;

        Role foundedRole = findByName(role.getName());
        if (foundedRole == null) return -1;
        roleDao.delete(foundedRole);
        return 1;
    }

    @Override
    public Role save(Role role) {
        Role foundRole =  findByName(role.getName());
        if(foundRole != null) return foundRole;
        Set<Permission> perms = new HashSet<>();
        role.getPermissions().forEach(perm -> {
            perms.add(permissionService.save(perm));
        });
        role.setPermissions(perms);
        return roleDao.save(role);
    }

    @Override
    public Set<Role> findByUserName(String username) {
        if (username == null) return Collections.emptySet();
        return roleDao.findAllByUsersUsername(username);
    }
}
