package org.ict.lookism.discovery;

import jakarta.persistence.*;
import org.ict.lookism.member.entity.Member;

@Entity
@Table(name = "lookism_interests", uniqueConstraints = @UniqueConstraint(columnNames = {"sender_id", "target_id"}))
class Interest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sender_id")
    Member sender;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "target_id")
    Member target;

    protected Interest() {}

    Interest(Member sender, Member target) {
        this.sender = sender;
        this.target = target;
    }
}
