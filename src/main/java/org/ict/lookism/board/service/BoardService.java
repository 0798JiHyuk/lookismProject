package org.ict.lookism.board.service;

import org.ict.lookism.board.vo.Board;
import org.ict.lookism.common.Paging;
import org.ict.lookism.common.Search;
import org.ict.lookism.common.SearchDate;

import java.util.ArrayList;

public interface BoardService {
    int selectListCount();

    ArrayList<Board> selectList(Paging paging);

    int insertOriginBoard(Board board);

    void updateAddReadCount(int boardNum);

    Board selectBoard(int boardNum);

    int updateReplySeq(Board reply);

    int insertReply(Board reply);

    int deleteBoard(Board board);

    int updateOriginBoard(Board board);

    int updateReplyBoard(Board reply);

    ArrayList<Board> selectSearchTitle(Search search);

    ArrayList<Board> selectSearchWriter(Search search);

    ArrayList<Board> selectSearchDate(Search search);

    int selectSearchTitleCount(String keyword);

    int selectSearchWriterCount(String keyword);

    int selectSearchDateCount(SearchDate date);
}
