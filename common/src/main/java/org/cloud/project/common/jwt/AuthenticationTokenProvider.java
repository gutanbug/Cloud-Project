package org.cloud.project.user.jwt;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationTokenProvider {
    String getAccessTokenFromHeader(HttpServletRequest request);

    Authentication getAuthentication(String accessToken);

}
