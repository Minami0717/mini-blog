package org.minami.minamiblog.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.minami.minamiblog.common.jpa.BaseEntity;

import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@SQLRestriction("deleted = 0")
@SQLDelete(sql = "UPDATE post SET deleted = 1 WHERE post_id = ?")
public class Post extends BaseEntity {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Long postId;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @Column(nullable = false, columnDefinition = "tinyint")
    @ColumnDefault("0")
    private int deleted;

    @OneToMany(mappedBy = "post")
    private List<Cmt> cmts;
}
