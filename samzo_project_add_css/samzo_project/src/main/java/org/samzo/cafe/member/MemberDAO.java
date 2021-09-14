package org.samzo.cafe.member;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO{
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	
	public List<MemberDTO> selectAll(){
		System.out.println("회원조회 기능 실행");
		System.out.println(mybatis);
		List<MemberDTO> list = mybatis.selectList("org.samzo.cafe.UserMapper.selectAll");
		System.out.println(list);
		if(list == null) {
			return null;
		}else {
			return list;
		}
	}
	
	public MemberDTO  selectOne(MemberDTO dto) {
		System.out.println("회원매칭 기능 실행");
		dto = mybatis.selectOne("org.samzo.cafe.UserMapper.selectOne",dto);
		System.out.println(dto);
		if(dto == null) {
			return null;
		}else {
			return mybatis.selectOne("org.samzo.cafe.UserMapper.selectOne",dto);
		}
		
	}
	
	public void insert(MemberDTO dto) {
		System.out.println("회원가입 기능 실행");
		mybatis.insert("org.samzo.cafe.UserMapper.insert",dto);
	}
	
	public void update(MemberDTO dto) {
		System.out.println("회원정보 수정 기능 실행");
		mybatis.update("org.samzo.cafe.UserMapper.update",dto);
	}
	
	public void delete(MemberDTO dto) {
		System.out.println("회원 탈퇴 기능 실행");
		mybatis.delete("org.samzo.cafe.UserMapper.delete",dto);
	}
}

