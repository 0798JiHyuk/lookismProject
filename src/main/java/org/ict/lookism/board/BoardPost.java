package org.ict.lookism.board;

import jakarta.persistence.*;
import java.time.Instant;
import org.ict.lookism.member.entity.Member;

@Entity
@Table(name = "lookism_posts")
class BoardPost {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Member author;
    @Column(nullable = false, length = 120)
    String title;
    @Column(nullable = false, length = 4000)
    String body;
    @Column(nullable = false)
    Instant createdAt;
    @Version
    long version;

    protected BoardPost() {}

    BoardPost(Member author, String title, String body) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.createdAt = Instant.now();
    }
}
