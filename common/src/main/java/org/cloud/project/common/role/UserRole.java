package org.cloud.project.common.role;

import lombok.Getter;
import org.cloud.project.common.jwt.AppAuthentication;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.cloud.project.common.role.UserAuthNames.*;

@Getter
public enum UserRole {
    USER(ROLE_USER),
    GUEST(ROLE_GUEST),
    ADMIN(combine(ROLE_ADMIN, ROLE_USER));

    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    private static final Map<String, UserRole> BY_LABEL =
            Stream.of(values()).collect(Collectors.toMap(UserRole::getName, e -> e));

    public static UserRole of(String name) {
        return BY_LABEL.get(name);
    }

    public static UserRole from(AppAuthentication auth) {
        if (auth == null) {
            return GUEST;
        }
        return auth.getUserRole();
    }

    public boolean isAdmin() {
        return this == ADMIN;
    }
}
