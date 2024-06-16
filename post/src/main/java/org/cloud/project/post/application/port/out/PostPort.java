package org.cloud.project.post.application.port.out;

import org.cloud.project.post.adapter.out.persistence.PostEntity;
import org.cloud.project.post.domain.Post;

public interface PostPort {

    PostEntity createPost(
            Post.PostTitle title,
            Post.PostBody body,
            Post.PostAuthor author
    );

    void updatePost(
            Post.PostId id,
            Post.PostTitle title,
            Post.PostBody body
    );
}
