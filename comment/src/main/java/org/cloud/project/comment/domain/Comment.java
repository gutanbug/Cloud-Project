package org.cloud.project.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Comment {
    @Getter private final Long id;
    @Getter private final Long postId;
    @Getter private final String content;

    @Value
    public static class CommentId {
        public CommentId(Long value) {
            this.idValue = value;
        }
        Long idValue;
    }

    @Value
    public static class CommentPostId
    {
        public CommentPostId(Long value) {
            this.postIdValue = value;
        }
        Long postIdValue;
    }

    @Value
    public static class CommentContent {
        public CommentContent(String value) {
            this.contentValue = value;
        }
        String contentValue;
    }
}
