package org.samzo.cafe.board.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.samzo.cafe.board.BoardDTO;
import org.samzo.cafe.board.BoardService;
import org.samzo.cafe.board.Criteria;
import org.samzo.cafe.board.HorseDTO;
import org.samzo.cafe.board.PageMaker;
import org.samzo.cafe.board.ReplyDTO;
import org.samzo.cafe.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	PageMaker pageMaker = new PageMaker();

	@Autowired
	BoardDAO dao;

	@Override
	public ModelAndView boardList(Criteria cri) {
		ModelAndView mnv = new ModelAndView();
		List<BoardDTO> boardList = dao.getboardList(cri);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.listCount());
		System.out.println(cri);
		mnv.addObject("boardList", boardList);
		mnv.addObject("pageMaker", pageMaker);
		mnv.setViewName("board/list");
//		System.out.println(boardList);
		return mnv;
		
	}
	
	@Override
	public ModelAndView categoryList(Criteria cri) {
		ModelAndView mnv = new ModelAndView();
		List<BoardDTO> categorylist = dao.categoryList(cri);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.listCount());
		mnv.addObject("categorylist", categorylist);
		mnv.addObject("pageMaker", pageMaker);
		mnv.setViewName("board/category");
		return mnv;
	}
	
	public ModelAndView categoryinsert(BoardDTO dto) {
		ModelAndView mnv = new ModelAndView();
		dao.getinsertcategory(dto);
		mnv.setViewName("redirect:categoryinsert");
		return mnv;
	}

	@Override
	public ModelAndView categoryInputPage() {
		ModelAndView mnv = new ModelAndView();
		List<String> categoryList = dao.getCategoryInput();
		mnv.addObject("categorylist", categoryList);
		mnv.setViewName("board/categoryinsert");
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

	@Override
	public ModelAndView detail(BoardDTO dto, HttpSession session) {
		ModelAndView mnv = new ModelAndView();

		if (session.getAttribute("member") != null) {
			BoardDTO board = dao.getboard(dto);
			board.setBbs_views((board.getBbs_views() + 1));
			List<ReplyDTO> ReplyList = dao.Reply(board);
			dao.boardViewNum(board);
			mnv.addObject("board", board);
			mnv.addObject("ReplyList", ReplyList);
			mnv.setViewName("board/detail");
//			System.out.println("�뙎湲� = " + ReplyList);

		} else {
			mnv.setViewName("redirect:../login.do");
		}

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

	@Override
	public ModelAndView replyInsert(ReplyDTO dto) {
		ModelAndView mnv = new ModelAndView();
		dao.replyinsert(dto);
		mnv.setViewName("redirect:detail.do?bbs_number=" + dto.getR_bbs());
		return mnv;
	}

	@Override
	public ModelAndView replyDelete(ReplyDTO dto) {
		ModelAndView mnv = new ModelAndView();
		dao.replydelete(dto);
		System.out.println("�뙎湲� �궘�젣 = "+dto);
		mnv.setViewName("redirect:detail.do?bbs_number=" + dto.getR_bbs());
		return mnv;
	}

	@Override
	public ModelAndView boardSearch(String condition, String keyword,Criteria cri) {
		ModelAndView mnv = new ModelAndView();
//		Criteria dto = new Criteria();
		if(condition.equals("title")) {
//			dto.setBbs_title(condition);
//			dto.setBbs_content(keyword);
//			System.out.println(cri.getBbs_title());
//			System.out.println(cri.getBbs_content());
			cri.setBbs_title(keyword);
			List<BoardDTO> boardList = dao.searchTitle(cri);
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(dao.listCountTitle());
			System.out.println(boardList);
			mnv.addObject("boardList", boardList);
			mnv.addObject("pageMaker", pageMaker);
			mnv.setViewName("board/search");
			System.out.println(cri); 
			
		
			
		}else if (condition.equals("content")) {
//			dto.setBbs_title(condition);
//			dto.setBbs_content(keyword);
			cri.setBbs_content(keyword);
			List<BoardDTO> boardList = dao.searchContent(cri);
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(dao.listCountContent());
//			System.out.println(boardList);
			mnv.addObject("boardList", boardList);
			mnv.addObject("pageMaker", pageMaker);
			mnv.setViewName("board/search");
			System.out.println(cri); 
		}
		return mnv;
	}
	
	
}
