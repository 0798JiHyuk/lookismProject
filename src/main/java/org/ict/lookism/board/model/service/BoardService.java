package org.ict.lookism.board.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.board.entity.*;
import org.ict.lookism.board.model.dto.BoardDto;
import org.ict.lookism.common.Header;
import org.ict.lookism.common.Pagination;
import org.ict.lookism.common.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardRepositoryCustom boardRepositoryCustom;

    public Header<List<BoardDto>> getBoardList(Pageable pageable, SearchCondition searchCondition) {
        List<BoardDto> btos = new ArrayList<>();

        Page<Board> noticeEntities = boardRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (Board entity : noticeEntities) {
            BoardDto nto = BoardDto.builder()
                    .boardid(entity.getBoardid())
                    .boardtitle(entity.getBoardtitle())
                    .boardname(entity.getBoardname())
                    .boardbody(entity.getBoardbody())
                    .userid(entity.getUserid())
                    .readcount(entity.getReadcount())
                    .repyn(entity.getRepyn())
                    .originid(entity.getOriginid())
                    .reportyn(entity.getReportyn())
                    .hashtag(entity.getHashtag())
                    .writedate(LocalDateTime.parse(entity.getWritedate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))))
                    .modifydate(LocalDateTime.parse(entity.getModifydate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))))
                    .build();
            btos.add(nto);
        }
        Pagination pagination = new Pagination(
                (int) noticeEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );
        return Header.OK(btos, pagination);

    }
}
