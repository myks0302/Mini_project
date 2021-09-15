package org.samzo.cafe.board;

import javax.servlet.http.HttpSession;

import org.samzo.cafe.page.PageingDTO;
import org.springframework.web.servlet.ModelAndView;

public interface BoardService {

	ModelAndView boardList(Criteria cri);

	ModelAndView boardInputPage();
	
	ModelAndView categoryList(Criteria cri);
	
	ModelAndView categoryinsert(BoardDTO dto);
	
	ModelAndView categoryInputPage();

	ModelAndView boardInsert(BoardDTO dto);

	ModelAndView detail(BoardDTO dto, HttpSession session);

	ModelAndView modify(BoardDTO dto);

	ModelAndView modify2(BoardDTO dto);

	ModelAndView deleteBoard(BoardDTO dto);

	ModelAndView replyInsert(ReplyDTO dto);

	ModelAndView replyDelete(ReplyDTO dto);
	
	//蹂대뱶 寃��깋
	ModelAndView boardSearch(String condition, String keyword,Criteria cri);
}
