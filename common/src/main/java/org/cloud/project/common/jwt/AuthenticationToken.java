package org.cloud.project.user.jwt;

public interface AuthenticationToken {
    String getAccessToken();

    String getRefreshToken();
}
