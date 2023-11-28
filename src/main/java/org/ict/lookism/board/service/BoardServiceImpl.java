package org.ict.lookism.board.service;

import java.util.List;

import org.ict.lookism.board.entity.Board;
import org.ict.lookism.board.repository.BoardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;

    @Override
    @Transactional
    public void register(Board board) throws Exception{
        repository.save(board);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> list() throws Exception {
        return repository.findAll(Sort.by(Sort.Direction.DESC,"writedate"));
    }

    @Override
    @Transactional
    public Board read(String boardid) throws Exception {
        return repository.getReferenceById(Long.parseLong(boardid));
    }

    @Override
    @Transactional
    public void modify(Board board) throws Exception {
        Board boardEntity = repository.getReferenceById(Long.parseLong(board.getBoardid()));

        boardEntity.setBoardtitle(board.getBoardtitle());
        boardEntity.setBoardbody(board.getBoardbody());
        boardEntity.setBoardname(board.getBoardname());
        boardEntity.setWritedate(board.getWritedate());
        boardEntity.setUserid(board.getUserid());

    }

    @Override
    @Transactional
    public void remove(String boardid) throws Exception {
        repository.deleteById(Long.parseLong(boardid));

    }

}
