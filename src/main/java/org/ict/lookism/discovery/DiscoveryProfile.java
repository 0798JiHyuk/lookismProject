package org.ict.lookism.discovery;

import jakarta.persistence.*;
import org.ict.lookism.member.entity.Member;

@Entity
@Table(name = "lookism_discovery_profiles")
class DiscoveryProfile {
    @Id
    Long id;
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    Member member;
    @Column(nullable = false, length = 500)
    String introduction;
    boolean visible;

    protected DiscoveryProfile() {}

    DiscoveryProfile(Member member) { this.member = member; }
}
