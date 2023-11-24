package org.ict.lookism.files.service;

import org.ict.lookism.board.mapper.BoardMapper;
import org.ict.lookism.files.vo.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service("filesService")
@Transactional
public class FilesServiceImpl implements FilesService{
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Files> selectAllList() {
        return null;
    }

    @Override
    public List<Files> selectUserFilesList(String userId) {
        return null;
    }

    @Override
    public List<Files> selectBoardFilesList(String boardId) {
        return null;
    }

    @Override
    public List<Files> selectFile(String fileId) {
        return null;
    }

    @Override
    public List<Files> selectFileNamesList(String fileName) {
        return null;
    }

    @Override
    public List<Files> selectFileRegList(Timestamp regDate) {
        return null;
    }

    @Override
    public List<Files> selectFileDelList() {
        return null;
    }

    @Override
    public int insertFile(Files files) {
        return 0;
    }

    @Override
    public int deleteFile(String fileId) {
        return 0;
    }
}
