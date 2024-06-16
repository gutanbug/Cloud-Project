package org.cloud.project.user.adapter.in.web;

import lombok.Getter;
import org.cloud.project.common.entity.UserEntity;

@Getter
public class ResponseMyInfo {

    private final Long userId;

    private final String name;

    public ResponseMyInfo(UserEntity entity) {
        this.userId = entity.getId();
        this.name = entity.getName();
    }
}
