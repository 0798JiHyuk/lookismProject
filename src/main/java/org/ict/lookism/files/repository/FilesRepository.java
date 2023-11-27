package org.ict.lookism.files.repository;

import lombok.RequiredArgsConstructor;
import org.ict.lookism.files.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FilesRepository extends JpaRepository<Files, String> {
}
