package org.cloud.project.post.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Post {
    @Getter private final Long id;
    @Getter private final String title;
    @Getter private final String body;
    @Getter private final String author;

    public static Post createPost(
            PostId postId,
            PostTitle postTitle,
            PostBody postBody,
            PostAuthor postAuthor
    ) {
        return new Post(
                postId.getIdValue(),
                postTitle.getTitleValue(),
                postBody.getBodyValue(),
                postAuthor.getAuthorValue()
        );
    }

    @Value
    public static class PostId {
        public PostId(Long value) {
            this.idValue = value;
        }
        Long idValue;
    }

    @Value
    public static class PostTitle {
        public PostTitle(String value) {
            this.titleValue = value;
        }
        String titleValue;
    }

    @Value
    public static class PostBody {
        public PostBody(String value) {
            this.bodyValue = value;
        }
        String bodyValue;
    }

    @Value
    public static class PostAuthor {
        public PostAuthor(String value) {
            this.authorValue = value;
        }
        String authorValue;
    }
}
