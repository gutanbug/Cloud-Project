package org.cloud.project.post.application.port.in;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloud.project.common.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class UpdatePostCommand extends SelfValidating<UpdatePostCommand> {

    private final Long id;
    private final String title;
    private final String body;

    public UpdatePostCommand(Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;

        validateSelf();
    }
}
