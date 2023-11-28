package org.ict.lookism.files.repository;

import org.ict.lookism.files.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, String> {
}
