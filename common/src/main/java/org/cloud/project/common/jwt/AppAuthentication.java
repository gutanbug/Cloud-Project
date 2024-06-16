package org.cloud.project.user.jwt;

import org.cloud.project.user.role.UserRole;
import org.springframework.security.core.Authentication;

public interface AppAuthentication extends Authentication {

    Long getUserId();

    UserRole getUserRole();

    boolean isAdmin();
}
