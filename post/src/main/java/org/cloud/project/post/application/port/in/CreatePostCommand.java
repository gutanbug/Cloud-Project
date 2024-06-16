package org.cloud.project.post.application.port.in;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloud.project.common.SelfValidating;
import org.jetbrains.annotations.NotNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class CreatePostCommand extends SelfValidating<CreatePostCommand> {

    @NotNull
    private final String title;

    @NotNull
    private final String body;

    public CreatePostCommand(String title, String body) {
        this.title = title;
        this.body = body;

        this.validateSelf();
    }
}
