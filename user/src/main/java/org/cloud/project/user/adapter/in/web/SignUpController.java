package org.cloud.project.user.adapter;

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

public class SignUpController {

    private final SignUpUseCase signUpUseCase;

    @PostMapping(path = "/signup")
    User signUp(@RequestBody RequestSignup request) {
        SignUpCommand command = SignUpCommand.builder()
                .name(request.getName())
                .formId(request.getFormId())
                .password(request.getPassword())
                .build();

        return signUpUseCase.signUp(command);
    }

}
