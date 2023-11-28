package org.ict.lookism.files.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.files.entity.Files;
import org.ict.lookism.files.repository.FilesRepository;
import org.ict.lookism.files.repository.FilesRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilesService{
    private final FilesRepository filesRepository;
    private final FilesRepositoryCustom filesRepositoryCustom;


    public List<Files> selectAllList() {
        return null;
    }

    
    public List<Files> selectUserFilesList(String userId) {
        return null;
    }

    
    public List<Files> selectBoardFilesList(String boardId) {
        return null;
    }

    
    public List<Files> selectFile(String fileId) {
        return null;
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
        return 0;
    }

    
    public int deleteFile(String fileId) {
        return 0;
    }
}
