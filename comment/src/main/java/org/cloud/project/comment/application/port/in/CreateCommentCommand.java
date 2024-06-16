package org.cloud.project.comment.application.port.in;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloud.project.common.SelfValidating;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class CreateCommentCommand extends SelfValidating<CreateCommentCommand> {

    private final Long postId;
    private final String content;

    public CreateCommentCommand(Long postId, String content) {
        this.postId = postId;
        this.content = content;

        this.validateSelf();
    }
}
