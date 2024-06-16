package org.cloud.project.user.adapter.in.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.cloud.project.common.WebAdapter;
import org.cloud.project.common.entity.UserEntity;
import org.cloud.project.common.jwt.AuthenticationToken;
import org.cloud.project.common.jwt.JwtProvider;
import org.cloud.project.user.application.port.in.LoginCommand;
import org.cloud.project.user.application.port.in.LoginUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Tag(name = "로그인 컨트롤러", description = "로그인 관련 컨트롤러")
public class LoginController {

    private final LoginUseCase loginUseCase;
    private final JwtProvider jwt;

    /**
     * 로그인
     */
    @PostMapping(path = "/login")
    public ResponseToken login(@RequestBody RequestLogin request) {
        LoginCommand command = LoginCommand.builder()
                .formId(request.getFormId())
                .password(request.getPassword())
                .build();

        UserEntity entity = loginUseCase.login(command);
        AuthenticationToken token = jwt.issue(entity);
        return new ResponseToken(token);
    }
}
