package org.minami.minamiblog.post.model;

import java.util.List;

public record PostDetailDto(
        Long postId,
        String title,
        String content,
        List<CmtDto> cmts
) {}
