package org.cloud.project.common.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.cloud.project.common.role.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "cloud_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String formId;
    private String name;
    private String password;
    private UserRole userRole;

    public UserEntity(String formId, String name, String password) {
        this.formId = formId;
        this.name = name;
        this.password = password;
        this.userRole = UserRole.USER;
    }
}
