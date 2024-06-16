package org.cloud.project.user.application.port.in;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloud.project.common.SelfValidating;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class MyInfoCommand extends SelfValidating<MyInfoCommand> {

    @NotNull
    private final Long userId;

    public MyInfoCommand(Long userId) {
        this.userId = userId;

        this.validateSelf();
    }
}

