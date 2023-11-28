package org.ict.lookism.board.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.ict.lookism.board.entity.Board;
import org.ict.lookism.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService service;

    @PostMapping
    public ResponseEntity<Board> register(@Validated @RequestBody Board board) throws Exception {
        board.setWritedate(new Date(Calendar.getInstance().getTimeInMillis()));
        service.register(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Board>> list() throws Exception {

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{boardid}")
    public ResponseEntity<Board> read(@PathVariable("boardid") String boardid) throws Exception {

        Board board = service.read(boardid);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PatchMapping("/{boardid}")
    public ResponseEntity<Board> modify(@PathVariable("boardid") String boardid, @Validated @RequestBody Board board) throws Exception{

        board.setBoardid(boardid);
        service.modify(board);

        return new ResponseEntity<>(board, HttpStatus.OK);

    }

    @DeleteMapping("/{boardid}")
    public ResponseEntity<Void> remove(@PathVariable("boardid") String boardid) throws Exception {

        service.remove(boardid);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



}














