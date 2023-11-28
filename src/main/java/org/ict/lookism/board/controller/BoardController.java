package org.ict.lookism.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.board.entity.Board;
import org.ict.lookism.board.model.dto.BoardDto;
import org.ict.lookism.board.model.service.BoardService;
import org.ict.lookism.common.Header;
import org.ict.lookism.common.SearchCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class BoardController {

	private final BoardService boardService;

	@GetMapping("/board/list")
	public Header<List<BoardDto>> boardList(
			@PageableDefault(sort = {"writeDate"}) Pageable pageable,
			SearchCondition searchCondition
	) {
		return boardService.getBoardList(pageable, searchCondition);
	}





}














