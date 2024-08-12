package org.sir.appgestionstock.zsecurity.permissions.resources;
import org.sir.appgestionstock.zsecurity.permissions.PermissionResource;

public enum RolePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    RolePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "client";
    }

    @Override
    public String authority() {
        return value;
    }
}
