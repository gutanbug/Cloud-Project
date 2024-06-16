package org.cloud.project.comment.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.cloud.project.comment.application.port.out.CommentPort;
import org.cloud.project.comment.domain.Comment;
import org.cloud.project.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class CommentPersistenceAdapter implements CommentPort {

    private final CommentRepository commentRepository;

    @Override
    public CommentEntity createComment(Comment.CommentContent content, Comment.CommentPostId postId) {
        return commentRepository.save(
                new CommentEntity(
                        postId.getPostIdValue(),
                        content.getContentValue()
                )
        );
    }
}
