package org.samzo.cafe.board.impl;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.samzo.cafe.board.BoardDTO;
import org.samzo.cafe.board.Criteria;
import org.samzo.cafe.board.HorseDTO;
import org.samzo.cafe.board.ReplyDTO;
import org.samzo.cafe.page.PageingDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	SqlSessionTemplate mybatis;

	public List<BoardDTO> getboardList(Criteria cri) {
		return mybatis.selectList("org.samzo.cafe.BoardMapper.selectAll", cri);
	}
	
	public int listCount() {
		return mybatis.selectOne("org.samzo.cafe.BoardMapper.listCount");
	}
	
	public int listCountTitle() {
		return mybatis.selectOne("org.samzo.cafe.BoardMapper.listCountTitle");
	}
	
	public int listCountContent() {
		return mybatis.selectOne("org.samzo.cafe.BoardMapper.listCountContent");
	}

	public List<String> getCategory() {
		return mybatis.selectList("org.samzo.cafe.BoardMapper.getCategory");
	}
	
	public List<String> getCategoryInput() {
		return mybatis.selectList("org.samzo.cafe.BoardMapper.getCategoryInput");
	}

	public BoardDTO getboard(BoardDTO dto) {
		return mybatis.selectOne("org.samzo.cafe.BoardMapper.selectBoard", dto);
	}

	public void getinsert(BoardDTO dto) {
		mybatis.selectList("org.samzo.cafe.BoardMapper.insertboard", dto);
	}
	
	public void getinsertcategory(BoardDTO dto) {
		mybatis.selectList("org.samzo.cafe.BoardMapper.insertcategory", dto);
	}

	public void getupdate(BoardDTO dto) {
		mybatis.selectList("org.samzo.cafe.BoardMapper.updateboard", dto);
	}

	public void deleteBoardProcess(BoardDTO dto) {
		mybatis.selectList("org.samzo.cafe.BoardMapper.deleteBoard", dto);
	}

	public void boardViewNum(BoardDTO dto) {
		mybatis.update("org.samzo.cafe.BoardMapper.updateViewsNumber", dto);
	}
	
	public List<HorseDTO> boardhorse() {
		return mybatis.selectList("org.samzo.cafe.BoardMapper.getHead");
	}
	
	public List<ReplyDTO> Reply(BoardDTO dto) {
//		System.out.println(mybatis.selectList("org.samzo.cafe.BoardMapper.getReply"));
		return mybatis.selectList("org.samzo.cafe.BoardMapper.getReply",dto);
	}
	public void replyinsert(ReplyDTO dto) {
		mybatis.selectList("org.samzo.cafe.BoardMapper.insertReply", dto);
	}

	public void replydelete(ReplyDTO dto) {
//		System.out.println("댓글담?");
		mybatis.selectList("org.samzo.cafe.BoardMapper.deleteReply", dto);
	}
	public List<BoardDTO> categoryList(Criteria cri) {	
//		System.out.println("baordDAO="+mybatis.selectList("org.samzo.cafe.BoardMapper.selectCategory"));
		return mybatis.selectList("org.samzo.cafe.BoardMapper.selectCategory", cri);
	}
	
	public List<BoardDTO> searchTitle(Criteria cri){
		System.out.println("제목으로 검색했냐" + cri);
		return mybatis.selectList("org.samzo.cafe.BoardMapper.searchTitle", cri);
	}
	
	public List<BoardDTO> searchContent(Criteria cri){
		System.out.println("내용으로 검색했냐" + cri);
		return mybatis.selectList("org.samzo.cafe.BoardMapper.searchContent", cri);
	}
}
