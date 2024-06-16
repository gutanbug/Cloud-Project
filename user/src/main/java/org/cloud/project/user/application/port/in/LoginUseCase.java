package org.cloud.project.user.application.port.in;

import org.cloud.project.common.entity.UserEntity;

public interface LoginUseCase {

    UserEntity login(LoginCommand command);
}
