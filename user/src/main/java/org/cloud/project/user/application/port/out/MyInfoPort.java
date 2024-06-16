package org.cloud.project.user.application.port.out;

import org.cloud.project.common.entity.UserEntity;
import org.cloud.project.user.domain.User;

public interface MyInfoPort {

    UserEntity getMyInfo(User.UserId userId);
}
