package org.ict.lookism.files.repository;

import org.ict.lookism.files.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilesRepository extends JpaRepository<Files, String> {
    public List<Files> findByUserId(Long userId);
    public List<Files> findByBoardId(Long boardId);


}
