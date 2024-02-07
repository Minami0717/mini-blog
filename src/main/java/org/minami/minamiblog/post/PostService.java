package org.minami.minamiblog.post;

import lombok.RequiredArgsConstructor;
import org.minami.minamiblog.common.entity.Post;
import org.minami.minamiblog.common.repository.PostRepository;
import org.minami.minamiblog.post.model.PostDto;
import org.minami.minamiblog.post.model.PostInsParam;
import org.springframework.stereotype.Service;

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
}
