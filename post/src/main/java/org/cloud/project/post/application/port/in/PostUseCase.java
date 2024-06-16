package org.cloud.project.post.application.port.in;

public interface PostUseCase {

    Long createPost(CreatePostCommand command);

    void updatePost(UpdatePostCommand command);
}
