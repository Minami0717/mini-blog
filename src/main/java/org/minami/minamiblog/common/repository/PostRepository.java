package org.minami.minamiblog.common.repository;

import org.minami.minamiblog.common.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
