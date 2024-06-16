package org.cloud.project.user.adapter.in.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.cloud.project.common.WebAdapter;
import org.cloud.project.user.application.port.in.SignUpCommand;
import org.cloud.project.user.application.port.in.SignUpUseCase;
import org.cloud.project.user.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
@Tag(name = "회원가입 컨트롤러", description = "회원가입 관련 컨트롤러")
public class SignUpController {

    private final SignUpUseCase signUpUseCase;

    /**
     * 회원가입
     */
    @PostMapping(path = "/signup")
    User signUp(@RequestBody RequestSignup request) {
        SignUpCommand command = SignUpCommand.builder()
                .formId(request.getFormId())
                .name(request.getName())
                .password(request.getPassword())
                .build();

        return signUpUseCase.signUp(command);
    }

}
