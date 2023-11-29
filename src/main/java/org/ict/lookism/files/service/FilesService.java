package org.ict.lookism.files.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.files.entity.Files;
import org.ict.lookism.files.repository.FilesRepository;
import org.ict.lookism.files.repository.FilesRepositoryCustom;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilesService{
    private final FilesRepository filesRepository;
    private final FilesRepositoryCustom filesRepositoryCustom;


    public List<Files> selectAllList() {
        List<Files> files = filesRepository.findAll();
        return files;
    }

    
    public List<Files> selectUserFilesList(String userId) {
        log.info(userId);
        List<Files> files = filesRepository.findByUserId(userId);
        return files;
    }

    
    public List<Files> selectBoardFilesList(String boardId) {
        List<Files> files = filesRepository.findByBoardId(boardId);
        return files;
    }

    
    public Optional<Files> selectFile(String fileId) {
        List<String> ids = Arrays.asList(fileId);
        Optional<Files> files = filesRepository.findById(fileId);
        return files;
    }

    
    public List<Files> selectFileNamesList(String fileName) {
        return null;
    }

    
    public List<Files> selectFileRegList(Timestamp regDate) {
        return null;
    }

    
    public List<Files> selectFileDelList() {
        return null;
    }

    
    public int insertFile(Files files) {
        filesRepository.save(files);
        return 1;
    }

    
    public int deleteFile(String fileId) {
        return 0;
    }
}
