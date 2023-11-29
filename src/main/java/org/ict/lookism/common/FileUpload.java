package org.ict.lookism.common;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;

@Slf4j
public class FileUpload {

    public static String uploadImageFile(String userId, String boardId, String originalFileName, byte[] fileData) throws Exception {
        if(fileData.length > 0) {
            TikaConfig tc = new TikaConfig();
            Metadata md = new Metadata();
            String mimeType = tc.getDetector().detect(TikaInputStream.get(fileData), md).toString();
            log.info(mimeType);

            if(mimeType.contains("image")){
                String savePath = System.getProperty("user.dir") + File.separator + "files";
                String userPath = savePath + File.separator + userId;
                File userFilePath = new File(userPath);
                if (!userFilePath.isDirectory()) {
                    Files.createDirectory(userFilePath.toPath());
                }
                String boardPath = userPath + File.separator + boardId;
                File boardFilePath = new File(boardPath);
                if (!boardFilePath.isDirectory()) {
                    Files.createDirectory(boardFilePath.toPath());
                }
                File target = new File(boardPath, originalFileName);

                FileCopyUtils.copy(fileData, target);

                String thumbName = "thumb_" + originalFileName;
                try (ByteArrayInputStream bais = new ByteArrayInputStream(fileData)) {

                    Thumbnails.of(bais)
                            .size(100, 100)
                            .outputFormat("jpg")
                            .toFile(new File(boardPath + File.separator + thumbName));
                } catch(Exception e){
                    log.info("Thumbnailator error");
                    e.printStackTrace();
                }

                return boardPath + File.separator + originalFileName;
            }else {
                throw new Exception("Given File Data is not an Image File");
            }


        } else {
            throw new Exception("Given File's length is 0");
        }

    }

    private static String getUploadedFilePath(String userId, String boardId) {
        return "";
    }

    private static int makeDir(String uploadFilePath) {
        return 0;
    }
}