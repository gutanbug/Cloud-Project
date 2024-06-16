package org.cloud.project.post.adapter.out.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;
    private String title;
    private String body;
    private String author;

    public PostEntity(String title, String body, String author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public void update(String titleValue, String bodyValue) {
        this.title = titleValue;
        this.body = bodyValue;
    }
}
