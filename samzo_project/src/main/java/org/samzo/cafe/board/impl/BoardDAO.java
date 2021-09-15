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

	public List<String> getCategory() {
		return mybatis.selectList("org.samzo.cafe.BoardMapper.getCategory");
	}

	public BoardDTO getboard(BoardDTO dto) {
		return mybatis.selectOne("org.samzo.cafe.BoardMapper.selectBoard", dto);
	}

	public void getinsert(BoardDTO dto) {
		mybatis.selectList("org.samzo.cafe.BoardMapper.insertboard", dto);
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
		System.out.println(mybatis.selectList("org.samzo.cafe.BoardMapper.getReply"));
		return mybatis.selectList("org.samzo.cafe.BoardMapper.getReply",dto);
	}
	public void replyinsert(ReplyDTO dto) {
		mybatis.selectList("org.samzo.cafe.BoardMapper.insertReply", dto);
	}

	public void replydelete(ReplyDTO dto) {
		System.out.println("�뙎湲� �궘�젣");
		mybatis.selectList("org.samzo.cafe.BoardMapper.deleteReply", dto);
	}
	public List<BoardDTO> categoryList(BoardDTO dto) {	
		System.out.println("baordDAO="+mybatis.selectList("org.samzo.cafe.BoardMapper.selectCategory"));
		return mybatis.selectList("org.samzo.cafe.BoardMapper.selectCategory",dto);
	}
	
	public List<BoardDTO> searchTitle(BoardDTO dto){
		System.out.println("寃뚯떆湲� �젣紐⑹쑝濡� 寃��깋");
		return mybatis.selectList("org.samzo.cafe.BoardMapper.searchTitle",dto);
	}
	
	public List<BoardDTO> searchContent(BoardDTO dto){
		System.out.println("寃뚯떆湲� �궡�슜�쑝濡� 寃��깋");
		return mybatis.selectList("org.samzo.cafe.BoardMapper.searchContent",dto);
	}
}
