package org.cloud.project.comment.adapter.in.web;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.cloud.project.comment.application.port.in.CommentUseCase;
import org.cloud.project.comment.application.port.in.CreateCommentCommand;
import org.cloud.project.common.WebAdapter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequiredArgsConstructor
@Tag(name = "댓글 컨트롤러", description = "댓글 관련 컨트롤러")
public class CommentController {

    private final CommentUseCase commentUseCase;

    /**
     * 댓글 생성
     */
    @Schema(description = "댓글 생성")
    @PostMapping("/create/{postId}")
    public Long createComment(@PathVariable Long postId, @RequestBody RequestCreateComment request) {
        CreateCommentCommand command = CreateCommentCommand.builder()
                .postId(postId)
                .content(request.getContent())
                .build();

        return commentUseCase.createComment(command);
    }
}
