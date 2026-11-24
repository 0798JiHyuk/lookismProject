package org.ict.lookism.discovery;

import jakarta.persistence.LockModeType;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

interface DiscoveryRepository extends JpaRepository<DiscoveryProfile, Long> {
    Slice<DiscoveryProfile> findByVisibleTrueAndIdNot(Long id, Pageable pageable);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from DiscoveryProfile p where p.id in :ids order by p.id")
    List<DiscoveryProfile> lockProfiles(List<Long> ids);
}
