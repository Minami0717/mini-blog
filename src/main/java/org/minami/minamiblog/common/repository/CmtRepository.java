package org.minami.minamiblog.common.repository;

import org.minami.minamiblog.common.entity.Cmt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CmtRepository extends JpaRepository<Cmt, Long> {
}
