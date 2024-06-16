package org.cloud.project.post.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.cloud.project.common.PersistenceAdapter;
import org.cloud.project.post.application.port.out.PostPort;
import org.cloud.project.post.domain.Post;

@PersistenceAdapter
@RequiredArgsConstructor
public class PostPersistenceAdapter implements PostPort {

    private final PostRepository repository;

    @Override
    public PostEntity createPost(Post.PostTitle title, Post.PostBody body, Post.PostAuthor author) {
        return repository.save(new PostEntity(title.getTitleValue(), body.getBodyValue(), author.getAuthorValue()));
    }

    @Override
    public void updatePost(Post.PostId id, Post.PostTitle title, Post.PostBody body) {
        PostEntity entity = repository.findById(id.getIdValue()).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        entity.update(title.getTitleValue(), body.getBodyValue());
    }
}
