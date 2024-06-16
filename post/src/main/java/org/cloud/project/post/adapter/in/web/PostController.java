package org.cloud.project.post.adapter.in.web;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.cloud.project.common.WebAdapter;
import org.cloud.project.post.application.port.in.CreatePostCommand;
import org.cloud.project.post.application.port.in.PostUseCase;
import org.cloud.project.post.application.port.in.UpdatePostCommand;
import org.springframework.web.bind.annotation.*;


@WebAdapter
@RestController
@RequiredArgsConstructor
@Tag(name = "게시글 컨트롤러", description = "게시글 관련 컨트롤러")
public class PostController {

    private final PostUseCase postUseCase;

    /**
     * 게시글 생성
     */
    @Schema(name = "RequestCreatePost", description = "게시글 생성 요청")
    @PostMapping("/create")
    public Long createPost(@RequestBody RequestCreatePost request) {
        CreatePostCommand command = CreatePostCommand.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .build();

        return postUseCase.createPost(command);
    }

    /**
     * 게시글 수정
     */
    @Schema(name = "RequestUpdatePost", description = "게시글 수정 요청")
    @PatchMapping("/update/{postId}")
    public void updatePost(@PathVariable Long postId, @RequestBody RequestUpdatePost request) {
        UpdatePostCommand command = UpdatePostCommand.builder()
                .id(postId)
                .title(request.getTitle())
                .body(request.getBody())
                .build();

        postUseCase.updatePost(command);
    }
}
