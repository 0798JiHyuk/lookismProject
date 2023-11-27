package org.ict.lookism.files.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.files.service.FilesService;
import org.ict.lookism.files.entity.Files;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/files")
public class FilesController {

    private final FilesService filesService;

    @GetMapping
    public ResponseEntity<List<Files>> selectAllList() throws Exception{
        return new ResponseEntity<>(filesService.selectAllList(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public List<Files> selectUserFilesList(String userId){
        return null;
    }

    @GetMapping("/board/{boardId}")
    public List<Files> selectBoardFilesList(String boardId){
        return null;
    }

    @GetMapping("/{fileId}")
    public List<Files> selectFile(String fileId){
        return null;
    }

    @GetMapping("/names/{fileName}")
    public List<Files> selectFileNamesList(String fileName){
        return null;
    }
    @GetMapping("/reg/{regDate}")
    public List<Files> selectFileRegList(Timestamp regDate){
        return null;
    }
    @GetMapping("/del")
    public List<Files> selectFileDelList(){
        return null;
    }

    @GetMapping("download")
    public ResponseEntity<byte[]> download(String fileId) throws Exception {
        return null;
    }
    @PostMapping(value = "/upload", produces = "text/plain;charset=utf-8")
    public ResponseEntity<String> uploadFile(MultipartFile file) throws Exception{
        return new ResponseEntity<String>("OK", HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/{boardId}")
    public int deleteFile(String userId, String boardId){
        filesService.deleteFile(boardId);
        return 0;
    };

}
