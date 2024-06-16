package org.cloud.project.user.adapter.out.persistence;

import org.cloud.project.common.entity.UserEntity;
import org.cloud.project.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToDomainEntity(UserEntity userEntity) {
        return User.createUser(
                new User.UserName(userEntity.getName()),
                new User.UserFormId(userEntity.getFormId()+""),
                new User.UserPassword(userEntity.getPassword())
        );
    }
}
