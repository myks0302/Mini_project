package org.samzo.cafe.board;

import org.springframework.web.servlet.ModelAndView;

public interface BoardService {
	
	ModelAndView boardList();
	
	ModelAndView boardInputPage();

	ModelAndView boardInsert(BoardDTO dto);
	
	ModelAndView detail(BoardDTO dto);
	
	ModelAndView modify(BoardDTO dto);
	
	ModelAndView modify2(BoardDTO dto);
	
	ModelAndView deleteBoard(BoardDTO dto);
	
}
