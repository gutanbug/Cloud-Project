package org.cloud.project.user.application.service;

import lombok.RequiredArgsConstructor;
import org.cloud.project.common.entity.UserEntity;
import org.cloud.project.user.application.port.in.MyInfoCommand;
import org.cloud.project.user.application.port.in.MyInfoUseCase;
import org.cloud.project.user.application.port.out.MyInfoPort;
import org.cloud.project.user.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyInfoService implements MyInfoUseCase {

    private final MyInfoPort myInfoPort;

    public UserEntity getMyInfo(MyInfoCommand command) {
        return myInfoPort.getMyInfo(new User.UserId(command.getUserId()));
    }


}
