package org.cloud.project.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class User {
    @Getter private final String name;
    @Getter private final String formId;
    @Getter private final String password;

    public static User createUser(
            UserName userName,
            UserFormId userFormId,
            UserPassword userPassword
    ) {
        return new User(
                userName.getNameValue(),
                userFormId.getFormIdValue(),
                userPassword.getPasswordValue()
        );
    }

    @Value
    public static class UserId {
        public UserId(Long value) {
            this.userId = value;
        }
        Long userId;
    }

    @Value
    public static class UserName {
        public UserName(String value) {
            this.nameValue = value;
        }
        String nameValue;
    }

    @Value
    public static class UserFormId {
        public UserFormId(String value) {
            this.formIdValue = value;
        }
        String formIdValue;
    }

    @Value
    public static class UserPassword {
        public UserPassword(String value) {
            this.passwordValue = value;
        }
        String passwordValue;
    }
}
