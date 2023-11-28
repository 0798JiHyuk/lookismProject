package org.ict.lookism.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.ict.lookism.board.service.BoardService;
import org.ict.lookism.board.entity.Board;
import org.ict.lookism.common.SearchDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.UnsupportedEncodingException;

@RestController
//@RestController
public class BoardController {
	//이 컨트롤러 안의 메소드들이 구동되는지, 값이 잘 전달되었는지 확인을 위한 로그 객체를 생성
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	//요청 처리용 ---------------------------------------------------------------
	@RequestMapping(value="btop3.do", method=RequestMethod.POST)
	@ResponseBody
	@GetMapping
	public String boardRCountTop3Method() throws UnsupportedEncodingException {
		return "";
	}
	
	//게시글 목록보기 요청 처리용 (페이징 처리)
	@RequestMapping("blist.do")
	public String boardListMethod(
			@RequestParam(name="page", required=false) String page, 
			@RequestParam(name="limit", required=false) String slimit, 
			Model model) {
		return "";
	}
	
	//게시글 제목 검색용 (페이징 처리 포함)
	@RequestMapping(value="bsearchTitle.do", method= RequestMethod.POST)
	public ModelAndView boardSearchTitleMethod(
			@RequestParam("action") String action,			
			@RequestParam("keyword") String keyword,
			@RequestParam(name="limit", required=false) String slimit,
			@RequestParam(name="page", required=false) String page,
			ModelAndView mv) {

		return mv;
	}
	
	//게시글 작성자 검색용 (페이징 처리 포함)
	@RequestMapping(value="bsearchWriter.do", method= RequestMethod.POST)
	public ModelAndView boardSearchWriterMethod(
			@RequestParam("action") String action,			
			@RequestParam("keyword") String keyword,
			@RequestParam(name="limit", required=false) String slimit,
			@RequestParam(name="page", required=false) String page,
			ModelAndView mv) {

		return mv;
	}
	
	//게시글 등록날짜로 검색용 (페이징 처리 포함)
	@RequestMapping(value="bsearchDate.do", method= RequestMethod.POST)
	public ModelAndView boardSearchDateMethod(
			SearchDate searchDate,
			@RequestParam("action") String action,
			@RequestParam(name="limit", required=false) String slimit,
			@RequestParam(name="page", required=false) String page,
			ModelAndView mv) {

		return mv;
	}
	
	//게시글 상세보기 요청 처리용
	@RequestMapping("bdetail.do")
	public ModelAndView boardDetailMethod(
			@RequestParam("bnum") int boardNum, 
			@RequestParam(name="page", required=false) String page,
			ModelAndView mv) {		

		
		return mv;
	}

	//새 게시원글 등록 요청 처리용 (파일 업로드 기능 추가)
	@RequestMapping(value="binsert.do", method=RequestMethod.POST)
	public String boardInsertMethod(Board board, Model model, HttpServletRequest request,
			@RequestParam(name="upfile", required=false) MultipartFile mfile) {
		logger.info("binsert.do : " + board);
		
		return "";
	}

	//게시글 삭제 요청 처리용
	@RequestMapping("bdelete.do")
	public String boardDeleteMethod(
			Board board, 	HttpServletRequest request, Model model) {
		
		return "";
	}
	
	//첨부파일 다운로드 요청 처리용
	@RequestMapping("bfdown.do")
	public ModelAndView fileDownMethod(
			ModelAndView mv, HttpServletRequest request, 
			@RequestParam("ofile") String originalFileName,
			@RequestParam("rfile") String renameFileName) {
		//파일 다운 메소드는 리턴 타입이 ModelAndView 로 정해져 있음
		
		//게시글 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath(
				"resources/board_upfiles");
		
		//저장 폴더에서 읽을 파일에 대한 파일 객체 생성함
		File renameFile = new File(savePath + "\\" + renameFileName);
		//파일 다운시 브라우저 내보낼 원래 파일이름에 대한 파일 객체 생성함
		File originFile = new File(originalFileName);
		
		//파일 다운로드용 뷰로 전달할 정보 저장 처리
		mv.setViewName("filedown");   //등록된 파일다운로드용 뷰클래스의 id명
		mv.addObject("renameFile", renameFile);
		mv.addObject("originFile", originFile);
		
		return mv;
	}
	
	//게시 원글 수정 요청 처리용 (파일 업로드 기능 사용)
	@RequestMapping(value="boriginupdate.do", method=RequestMethod.POST)
	public String boardOriginUpdateMethod(Board board, Model model, 
			HttpServletRequest request, 
			@RequestParam(name="deleteFlag", required=false) String delFlag,
			@RequestParam(name="page", required=false) String page,
			@RequestParam(name="upfile", required=false) MultipartFile mfile) {
		return "";
	}
	
	//게시 댓글, 대댓글 등록 처리용
	@RequestMapping(value="breply.do", method=RequestMethod.POST)
	public String replyInsertMethod(Board reply, 
			@RequestParam("bnum") String bnum,
			@RequestParam("page") String page, Model model) {
		return "";
	}
	
	//댓글과 대댓글 수정 처리용
	@RequestMapping(value="breplyupdate.do", method=RequestMethod.POST)
	public String replyUpdateMethod(Board reply, 
			@RequestParam("page") String page, Model model) {
		return "";
	}
}














