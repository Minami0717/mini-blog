package org.minami.minamiblog.cmt;

import lombok.RequiredArgsConstructor;
import org.minami.minamiblog.cmt.model.CmtInsParam;
import org.minami.minamiblog.common.entity.Cmt;
import org.minami.minamiblog.common.entity.Post;
import org.minami.minamiblog.common.repository.CmtRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CmtService {
    private final CmtRepository rep;

    public int insCmt(CmtInsParam p) {
        rep.save(Cmt.builder()
                .post(Post.builder().postId(p.postId()).build())
                .content(p.content())
                .build());
        return 1;
    }
}
