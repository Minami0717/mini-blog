package org.minami.minamiblog.post;

import lombok.RequiredArgsConstructor;
import org.minami.minamiblog.common.entity.Post;
import org.minami.minamiblog.common.repository.PostRepository;
import org.minami.minamiblog.post.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository rep;

    public int insPost(PostInsParam p) {
        rep.save(Post.builder()
                .title(p.title())
                .content(p.content())
                .build());
        return 1;
    }

    public List<PostDto> getPost() {
        return rep.findAll().stream()
                .map(p -> new PostDto(p.getPostId(), p.getTitle()))
                .toList();
    }

    public PostDetailDto getPostById(Long postId) {
        Post p = rep.findById(postId).orElseThrow();
        return new PostDetailDto(
                p.getPostId(),
                p.getTitle(),
                p.getContent(),
                p.getCmts().stream().map(c -> new CmtDto(c.getCmtId(), c.getContent())).toList());
    }

    @Transactional
    public int updPost(PostUpdParam param) {
        rep.findById(param.postId()).orElseThrow()
                .updPost(param);
        return 1;
    }

    public int delPostById(Long postId) {
        rep.deleteById(postId);
        return 1;
    }
}
