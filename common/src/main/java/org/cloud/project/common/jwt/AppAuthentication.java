package org.cloud.project.common.jwt;

import org.cloud.project.common.role.UserRole;
import org.springframework.security.core.Authentication;

public interface AppAuthentication extends Authentication {

    Long getUserId();

    UserRole getUserRole();

    boolean isAdmin();
}
