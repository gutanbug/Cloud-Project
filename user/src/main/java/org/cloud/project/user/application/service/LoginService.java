package org.cloud.project.user.application.service;

import lombok.RequiredArgsConstructor;
import org.cloud.project.common.entity.UserEntity;
import org.cloud.project.user.application.port.in.LoginCommand;
import org.cloud.project.user.application.port.in.LoginUseCase;
import org.cloud.project.user.application.port.out.LoginPort;
import org.cloud.project.user.domain.User;
import org.cloud.project.common.jwt.JwtProvider;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginService implements LoginUseCase {

    private final LoginPort loginPort;

    @Override
    public UserEntity login(LoginCommand command) {
        return loginPort.loginUser(
                new User.UserFormId(command.getFormId()),
                new User.UserPassword(command.getPassword())
        );
    }
}
