package org.cloud.project.common.jwt;

public interface AuthenticationToken {
    String getAccessToken();

    String getRefreshToken();
}
