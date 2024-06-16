package org.cloud.project.user.application.port.in;

import org.cloud.project.user.domain.User;

public interface SignUpUseCase {
    User signUp(SignUpCommand command);
}
