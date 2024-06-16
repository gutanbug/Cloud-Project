package org.cloud.project.comment.application.port.out;

import org.cloud.project.comment.domain.Comment;

public interface CommentPort {

    Long createComment(
            Comment.CommentContent content,
            Comment.CommentPostId postId
    );
}
