package org.cloud.project.user.application.service;

import lombok.RequiredArgsConstructor;
import org.cloud.project.common.entity.UserEntity;
import org.cloud.project.user.adapter.out.persistence.UserMapper;
import org.cloud.project.user.application.port.in.SignUpCommand;
import org.cloud.project.user.application.port.in.SignUpUseCase;
import org.cloud.project.user.application.port.out.SignUpPort;
import org.cloud.project.user.domain.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SignUpService implements SignUpUseCase {

    private final SignUpPort signUpPort;
    private final UserMapper userMapper;

    @Override
    public User signUp(SignUpCommand command) {
        UserEntity entity = signUpPort.signUpUser(
                new User.UserFormId(command.getFormId()),
                new User.UserName(command.getName()),
                new User.UserPassword(command.getPassword())
        );
        return userMapper.mapToDomainEntity(entity);
    }
}
