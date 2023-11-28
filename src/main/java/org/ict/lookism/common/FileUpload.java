package org.ict.lookism.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.nio.file.Files;

@Slf4j
public class FileUpload {

    public static String uploadFile(String userId, String boardId, String originalFileName, byte[] fileData) throws Exception {
        String savePath = System.getProperty("user.dir") + File.separator + "files";
        String userPath = savePath + File.separator + userId;
        File userFilePath = new File(userPath);
        if(!userFilePath.isDirectory()) {
            Files.createDirectory(userFilePath.toPath());
        }
        String boardPath = userPath + File.separator + boardId;
        File boardFilePath = new File(boardPath);
        if(!userFilePath.isDirectory()) {
            Files.createDirectory(boardFilePath.toPath());
        }
        File target = new File(boardPath, originalFileName);

        FileCopyUtils.copy(fileData, target);

        return boardPath + File.separator + originalFileName;
    }

    private static String getUploadedFilePath(String userId, String boardId) {
        return "";
    }

    private static int makeDir(String uploadFilePath) {
        return 0;
    }
}