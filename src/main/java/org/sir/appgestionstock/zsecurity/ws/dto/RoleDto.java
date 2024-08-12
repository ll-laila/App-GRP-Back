package org.sir.appgestionstock.zsecurity.ws.dto;

import org.sir.appgestionstock.zutils.webservice.dto.AuditBaseDto;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class RoleDto extends AuditBaseDto {
private String name;
private String label;

private List<AppUserDto> users;

private Set<PermissionDto> permissions = new HashSet<>();

public RoleDto() {
}

public String getName() {
return this.name;
}

public String getLabel() {
return this.label;
}

public List<AppUserDto> getUsers() {
return this.users;
}

public void setName(String name) {
this.name = name;
}

public void setLabel(String label) {
this.label = label;
}

public void setUsers(List<AppUserDto> users) {
this.users = users;
}

public Set<PermissionDto> getPermissions() {
return permissions;
}

public void setPermissions(Set<PermissionDto> permissions) {
this.permissions = permissions;
}
}
