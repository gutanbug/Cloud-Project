package org.cloud.project.user.application.port.in;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloud.project.common.SelfValidating;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class SignUpCommand extends SelfValidating<SignUpCommand> {

    @NotNull
    private final String formId;

    @NotNull
    private final String name;

    @NotNull
    private final String password;

    public SignUpCommand(String formId, String name, String password) {
        this.formId = formId;
        this.name = name;
        this.password = password;

        this.validateSelf();
    }
}
