package org.samzo.cafe.board.impl;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.samzo.cafe.board.BoardDTO;
import org.samzo.cafe.board.HorseDTO;
import org.samzo.cafe.board.ReplyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	SqlSessionTemplate mybatis;

	public List<BoardDTO> getboardList() {
		return mybatis.selectList("org.samzo.cafe.BoardMapper.selectAll");
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
	
	public List<ReplyDTO> Reply() {
		System.out.println(mybatis.selectList("org.samzo.cafe.BoardMapper.getReply"));
		return mybatis.selectList("org.samzo.cafe.BoardMapper.getReply");
	}
}
