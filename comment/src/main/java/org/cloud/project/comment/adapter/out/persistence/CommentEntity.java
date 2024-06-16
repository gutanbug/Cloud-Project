package org.cloud.project.comment.adapter.out.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "comment")
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private Long postId;

    private String content;

    public CommentEntity(Long postId, String content) {
        this.postId = postId;
        this.content = content;
    }
}
