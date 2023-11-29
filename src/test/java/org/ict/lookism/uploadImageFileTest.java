package org.ict.lookism;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.ict.lookism.common.FileUpload;
@SpringBootTest
public class uploadImageFileTest{
    @Test
    public void uploadImageFileTest(){

    byte[] filedata;

        try {
            filedata = Files.readAllBytes(Paths.get("e:\\a\\test.jpg"));
            System.out.println("filedata");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("second try");
            String result = FileUpload.uploadImageFile("user2","board2", "test.jpg",filedata);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

