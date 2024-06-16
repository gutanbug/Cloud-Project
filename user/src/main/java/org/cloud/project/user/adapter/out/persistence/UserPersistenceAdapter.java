package org.cloud.project.user.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.cloud.project.common.PersistenceAdapter;
import org.cloud.project.common.entity.UserEntity;
import org.cloud.project.user.application.port.out.LoginPort;
import org.cloud.project.user.application.port.out.MyInfoPort;
import org.cloud.project.user.application.port.out.SignUpPort;
import org.cloud.project.user.domain.User;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements SignUpPort, LoginPort, MyInfoPort {

    private final UserRepository repository;

    @Override
    public UserEntity signUpUser(User.UserFormId formId, User.UserName name, User.UserPassword password) {
        return repository.save(
                new UserEntity(
                        formId.getFormIdValue(),
                        name.getNameValue(),
                        password.getPasswordValue()
                )
        );
    }

    @Override
    public UserEntity loginUser(User.UserFormId userFormId, User.UserPassword userPassword) {
        UserEntity entity = repository.findByFormId(userFormId.getFormIdValue()).orElseThrow(() -> new RuntimeException("User not found"));
        if (!entity.getPassword().equals(userPassword.getPasswordValue())) {
            throw new RuntimeException("Invalid password");
        }
        return entity;
    }

    @Override
    public UserEntity getMyInfo(User.UserId userId) {
        return repository.findById(userId.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
