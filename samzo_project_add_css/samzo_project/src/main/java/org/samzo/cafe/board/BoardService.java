package org.samzo.cafe.board;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface BoardService {
	
	ModelAndView boardList();
	
	ModelAndView boardInputPage();

	ModelAndView boardInsert(BoardDTO dto);
	
	ModelAndView detail(BoardDTO dto, HttpSession session);
	
	ModelAndView modify(BoardDTO dto);
	
	ModelAndView modify2(BoardDTO dto);
	
	ModelAndView deleteBoard(BoardDTO dto);
	
}
