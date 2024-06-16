package org.cloud.project.comment.application.service;

import lombok.RequiredArgsConstructor;
import org.cloud.project.comment.application.port.in.CommentUseCase;
import org.cloud.project.comment.application.port.in.CreateCommentCommand;
import org.cloud.project.comment.application.port.out.CommentPort;
import org.cloud.project.comment.domain.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService implements CommentUseCase {

    private final CommentPort commentPort;

    @Override
    public Long createComment(CreateCommentCommand command) {

        commentPort.createComment(
                new Comment.CommentContent(command.getContent()),
                new Comment.CommentPostId(command.getPostId())
        );

    }
}
