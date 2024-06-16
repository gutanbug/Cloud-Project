package org.cloud.project.comment.application.port.in;

public interface CommentUseCase {

    Long createComment(CreateCommentCommand command);
}
