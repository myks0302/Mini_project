package org.samzo.cafe.board.impl;

import java.util.List;

import org.samzo.cafe.board.BoardDTO;
import org.samzo.cafe.board.BoardService;
import org.samzo.cafe.board.HorseDTO;
import org.samzo.cafe.board.ReplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;

	@Override
	public ModelAndView boardList() {
		ModelAndView mnv = new ModelAndView();
		List<BoardDTO> boardList = dao.getboardList();
		mnv.addObject("boardList", boardList);
		mnv.setViewName("board/list");
//		System.out.println(boardList);
		return mnv;
	}

	@Override
	public ModelAndView boardInputPage() {
		ModelAndView mnv = new ModelAndView();
		List<String> categoryList = dao.getCategory();
		List<HorseDTO> horseList = dao.boardhorse();
		mnv.addObject("categorylist", categoryList);
		mnv.addObject("horseList", horseList);
		mnv.setViewName("board/insert");
		return mnv;
	}

//	@Override
//	public ModelAndView Update(BoardDTO dto) {
//		ModelAndView mnv = new ModelAndView();
//		BoardDTO board = dao.getboard(dto);
//		mnv.addObject("board", board);
//		mnv.setViewName("board/modify");
//		return mnv;
//	}
//
//	@Override
//	public ModelAndView Update2(BoardDTO dto) {
//		ModelAndView mnv = new ModelAndView();
//		dao.updateboard(dto);
//		mnv.setViewName("redirect:datail.do?number=" + dto.getNumber());
//		return mnv;
//	}

	@Override
	public ModelAndView detail(BoardDTO dto) {
		ModelAndView mnv = new ModelAndView();
		BoardDTO board = dao.getboard(dto);
		board.setBbs_views((board.getBbs_views() + 1));
		List<ReplyDTO> ReplyList = dao.Reply();
		dao.boardViewNum(board);
		mnv.addObject("board", board);
		mnv.addObject("ReplyList", ReplyList);
		mnv.setViewName("board/detail");
		System.out.println("댓글 = "+ReplyList);
		return mnv;
	}

	@Override
	public ModelAndView boardInsert(BoardDTO dto) {
		ModelAndView mnv = new ModelAndView();
//		System.out.println("GTFO"+req.getParameter("BABABAB"));
		System.out.println(dto);
		dao.getinsert(dto);
		mnv.setViewName("redirect:list.do");
		return mnv;
	}

	@Override
	public ModelAndView modify(BoardDTO dto) {
		ModelAndView mnv = new ModelAndView();
		BoardDTO board = dao.getboard(dto);
		List<String> categoryList = dao.getCategory();
		List<HorseDTO> horseList = dao.boardhorse();
		mnv.addObject("categorylist", categoryList);
		mnv.addObject("horseList", horseList);
		mnv.addObject("board", board);
		mnv.setViewName("board/modify");
//		System.out.println(board);
		return mnv;

	}

	@Override
	public ModelAndView modify2(BoardDTO dto) {
		ModelAndView mnv = new ModelAndView();
		dao.getupdate(dto);
		mnv.setViewName("redirect:detail.do?bbs_number=" + dto.getBbs_number());
//		System.out.println(dto);
		return mnv;
	}

	@Override
	public ModelAndView deleteBoard(BoardDTO dto) {
		ModelAndView mav = new ModelAndView();
		dao.deleteBoardProcess(dto);
		mav.setViewName("redirect:list.do");

		return mav;
	}

}
