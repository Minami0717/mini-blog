package org.minami.minamiblog.post;

import lombok.RequiredArgsConstructor;
import org.minami.minamiblog.post.model.PostDto;
import org.minami.minamiblog.post.model.PostInsParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService service;

    @PostMapping
    public int insPost(@RequestBody PostInsParam p) {
        return service.insPost(p);
    }

    @GetMapping
    public List<PostDto> getPost() {
        return service.getPost();
    }
}
