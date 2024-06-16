package org.cloud.project.post.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.cloud.project.post.adapter.out.persistence.PostEntity;
import org.cloud.project.post.application.port.in.CreatePostCommand;
import org.cloud.project.post.application.port.in.PostUseCase;
import org.cloud.project.post.application.port.in.UpdatePostCommand;
import org.cloud.project.post.application.port.out.PostPort;
import org.cloud.project.post.domain.Post;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Service
@RequiredArgsConstructor
@Transactional
public class PostService implements PostUseCase {

    private final PostPort postPort;
    private final RestTemplate restTemplate;

    public Long createPost(CreatePostCommand command) {
        PostEntity entity = postPort.createPost(
                new Post.PostTitle(command.getTitle()),
                new Post.PostBody(command.getBody()),
                new Post.PostAuthor("author")
        );
        return entity.getId();
    }

    @Override
    public void updatePost(UpdatePostCommand command) {
        postPort.updatePost(
                new Post.PostId(command.getId()),
                new Post.PostTitle(command.getTitle()),
                new Post.PostBody(command.getBody())
        );
    }
}
