package org.ict.lookism.discovery;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface InterestRepository extends JpaRepository<Interest, Long> {
    boolean existsBySenderIdAndTargetId(Long senderId, Long targetId);
    void deleteBySenderIdAndTargetId(Long senderId, Long targetId);
    void deleteBySenderIdOrTargetId(Long senderId, Long targetId);
    List<Interest> findBySenderIdAndTargetIdIn(Long senderId, List<Long> targetIds);
    List<Interest> findByTargetIdAndSenderIdIn(Long targetId, List<Long> senderIds);
}
