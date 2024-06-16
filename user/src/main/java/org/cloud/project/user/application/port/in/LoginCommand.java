package org.cloud.project.user.application.port.in;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloud.project.common.SelfValidating;
import org.jetbrains.annotations.NotNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginCommand extends SelfValidating<LoginCommand> {

    @NotNull
    private final String formId;

    @NotNull
    private final String password;

    public LoginCommand(String formId, String password) {
        this.formId = formId;
        this.password = password;

        this.validateSelf();
    }
}
