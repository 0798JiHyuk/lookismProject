package org.ict.lookism.board.service;

import org.ict.lookism.board.entity.Board;
import org.ict.lookism.board.repository.BoardMapper;
import org.ict.lookism.common.Paging;
import org.ict.lookism.common.Search;
import org.ict.lookism.common.SearchDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("boardService")
@Transactional
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;	
	
	public ArrayList<Board> selectTop3() {
		List<Board> list = boardMapper.selectTop3();
		return (ArrayList<Board>)list;
	}
	
	@Override
	public int selectListCount() {
		return boardMapper.getListCount();
	}
	
	@Override
	public ArrayList<Board> selectList(Paging paging) {
		List<Board> list = boardMapper.selectList(paging);
		return (ArrayList<Board>)list;
	}
	
	@Override
	public int insertOriginBoard(Board board) {
		return boardMapper.insertOriginBoard(board);
	}
	
	@Override
	public void updateAddReadCount(int boardNum) {
		boardMapper.addReadCount(boardNum);	
	}
	
	@Override
	public Board selectBoard(int boardNum) {
		return boardMapper.selectBoard(boardNum);
	}
	
	@Override
	public int updateReplySeq(Board reply) {
		int result = 0;
//
//		if(reply.getBoardLev() == 2) {
//			result = boardMapper.updateReplySeq1(reply);
//		}
//		if(reply.getBoardLev() == 3) {
//			result = boardMapper.updateReplySeq2(reply);
//		}

		return result;
	}
	
	@Override
	public int insertReply(Board reply) {
		int result = 0;
		
//		if(reply.getBoardLev() == 2) {
//			result = boardMapper.insertReply1(reply);
//		}
//		if(reply.getBoardLev() == 3) {
//			result = boardMapper.insertReply2(reply);
//		}
//
		return result;		
	}
	
	@Override
	public int deleteBoard(Board board) {
		return boardMapper.deleteBoard(board);
	}
	
	@Override
	public int updateOriginBoard(Board board) {
		return boardMapper.updateOrigin(board);
	}	
	
	@Override
	public int updateReplyBoard(Board reply) {
		return boardMapper.updateReply(reply);
	}
	
	@Override
	public ArrayList<Board> selectSearchTitle(Search search) {
		List<Board> list = boardMapper.selectSearchTitle( search);
		return (ArrayList<Board>)list;
	}
	
	@Override
	public ArrayList<Board> selectSearchWriter(Search search) {
		List<Board> list = boardMapper.selectSearchWriter(search);
		return (ArrayList<Board>)list;
	}
	
	@Override
	public ArrayList<Board> selectSearchDate(Search search) {
		List<Board> list = boardMapper.selectSearchDate(search);
		return (ArrayList<Board>)list;
	}
	
	@Override
	public int selectSearchTitleCount(String keyword) {
		return boardMapper.getSearchTitleCount(keyword);
	}
	
	@Override
	public int selectSearchWriterCount(String keyword) {
		return boardMapper.getSearchWriterCount(keyword);
	}
	
	@Override
	public int selectSearchDateCount(SearchDate date) {
		return boardMapper.getSearchDateCount(date);
	}
}











