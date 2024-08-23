package org.sir.appgestionstock.zsecurity.permissions.resources;
import org.sir.appgestionstock.zsecurity.permissions.PermissionResource;

public enum EntrepriseDevisesPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    EntrepriseDevisesPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "entrepriseDevises";
    }

    @Override
    public String authority() {
        return value;
    }
}
