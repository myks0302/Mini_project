package org.samzo.cafe;

import org.samzo.cafe.board.BoardDTO;
import org.samzo.cafe.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board")
public class BoardController implements BoardService {

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView boardList() {

		return boardService.boardList();
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public ModelAndView boardInputPage() {
		return boardService.boardInputPage();
	}

//	@Override
//	@RequestMapping(value="modify.do",method = RequestMethod.GET)
//	public ModelAndView Update(BoardDTO dto) {
//		
//		return boardService.Update(dto);
//	}
//
//	@Override
//	@RequestMapping(value="modify.do",method = RequestMethod.POST)
//	public ModelAndView Update2(BoardDTO dto) {
//			
//		return boardService.Update2(dto);
//	}
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public ModelAndView detail(BoardDTO dto) {

		return boardService.detail(dto);
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public ModelAndView boardInsert(BoardDTO dto) {
//		System.out.println(req.getParameter("title"));
		return boardService.boardInsert(dto);
	}

	@Override
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public ModelAndView modify(BoardDTO dto) {
		System.out.println("확인["+dto+"}");
		return boardService.modify(dto);
	}

	@Override
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public ModelAndView modify2(BoardDTO dto) {
		System.out.println("확인2["+dto+"}");
		return boardService.modify2(dto);
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public ModelAndView deleteBoard(BoardDTO dto) {
		System.out.println(dto);
		return boardService.deleteBoard(dto);
	}

}
