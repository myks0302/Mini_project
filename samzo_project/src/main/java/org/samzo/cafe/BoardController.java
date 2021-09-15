package org.samzo.cafe;

import javax.servlet.http.HttpSession;

import org.samzo.cafe.board.BoardDTO;
import org.samzo.cafe.board.BoardService;
import org.samzo.cafe.board.Criteria;
import org.samzo.cafe.board.ReplyDTO;
import org.samzo.cafe.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board")
public class BoardController implements BoardService {

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView boardList(Criteria cri) {
		
		return boardService.boardList(cri);
	}
	@Override
	@RequestMapping(value="/category.go",method = RequestMethod.GET)
	public ModelAndView categoryList(BoardDTO dto) {
		
		return boardService.categoryList(dto);
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public ModelAndView boardInputPage() {
		return boardService.boardInputPage();
	}

	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public ModelAndView detail(BoardDTO dto, HttpSession session) {
		return boardService.detail(dto,session);
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public ModelAndView boardInsert(BoardDTO dto) {
//		System.out.println(req.getParameter("title"));
		return boardService.boardInsert(dto);
	}

	@Override
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public ModelAndView modify(BoardDTO dto) {
		System.out.println("�솗�씤[" + dto + "}");
		return boardService.modify(dto);
	}

	@Override
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public ModelAndView modify2(BoardDTO dto) {
		System.out.println("�솗�씤2[" + dto + "}");
		return boardService.modify2(dto);
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public ModelAndView deleteBoard(BoardDTO dto) {
		System.out.println(dto);
		return boardService.deleteBoard(dto);
	}

	@Override
	@RequestMapping(value = "/detail.do", method = RequestMethod.POST)
	public ModelAndView replyInsert(ReplyDTO dto) {
		
		return boardService.replyInsert(dto);
	}

	@Override
	@RequestMapping(value = "/rdel.do", method = RequestMethod.POST)
	public ModelAndView replyDelete(ReplyDTO dto) {
		System.out.println("�궘�젣 �솗�씤:" + dto);
		return boardService.replyDelete(dto);
	}
	
	@RequestMapping(value = "/search.do", method = RequestMethod.POST)
	public ModelAndView boardSearch(@RequestParam(value = "searchCondition", defaultValue="title", required= false) String condition,
								@RequestParam(value = "searchKeyword", defaultValue="", required = false) String keyword,Criteria cri) {
		System.out.println("寃��깋 議곌굔 :" + condition);
		System.out.println("寃��깋 �떒�뼱 :" + keyword);
		return boardService.boardSearch(condition, keyword,cri);
	}
}
