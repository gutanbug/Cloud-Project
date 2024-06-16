package org.cloud.project.user.adapter.in.web;

import lombok.Getter;
import org.cloud.project.common.jwt.AuthenticationToken;

@Getter
public class ResponseToken {
    private final String accessToken;
    private final String refreshToken;

    public ResponseToken(AuthenticationToken token) {
        this.accessToken = token.getAccessToken();
        this.refreshToken = token.getRefreshToken();
    }
}
