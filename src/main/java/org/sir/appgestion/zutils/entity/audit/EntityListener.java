package org.sir.appgestionstock.zutils.entity.audit;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.sir.appgestionstock.zsecurity.entity.AppUser;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class EntityListener implements Serializable {

    @PrePersist
    public void prePersist(AuditEntity auditBusinessObject) {

        if (auditBusinessObject.getCreatedOn() == null) {
            auditBusinessObject.setCreatedOn(LocalDateTime.now());
            auditBusinessObject.setCreatedBy(getCurrentUser());
        }
    }

    @PreUpdate
    public void preUpdate(AuditEntity auditBusinessObject) {
        auditBusinessObject.setUpdatedOn(LocalDateTime.now());
        auditBusinessObject.setUpdatedBy(getCurrentUser());
    }

    public String getCurrentUser() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (currentUser instanceof String) {
                return (String) currentUser;
            } else if (currentUser instanceof AppUser) {
                return ((AppUser) currentUser).getUsername();
            } else return null;
        }
        return null;
    }
}