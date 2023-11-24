package org.ict.lookism.files.service;

import org.ict.lookism.files.vo.Files;

import java.sql.Timestamp;
import java.util.List;

public interface FilesService {
    public List<Files> selectAllList();

    public List<Files> selectUserFilesList(String userId);
    public List<Files> selectBoardFilesList(String boardId);
    public List<Files> selectFile(String fileId);
    public List<Files> selectFileNamesList(String fileName);
    public List<Files> selectFileRegList(Timestamp regDate);
    public List<Files> selectFileDelList();

    public int insertFile(Files files);
    public int deleteFile(String fileId);
}
