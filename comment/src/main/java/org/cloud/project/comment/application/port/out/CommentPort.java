package org.cloud.project.comment.application.port.out;

import org.cloud.project.comment.adapter.out.persistence.CommentEntity;
import org.cloud.project.comment.domain.Comment;

public interface CommentPort {

    CommentEntity createComment(
            Comment.CommentContent content,
            Comment.CommentPostId postId
    );
}
