package org.samzo.cafe.member.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.samzo.cafe.member.MemberDTO;
import org.springframework.web.servlet.ModelAndView;


public interface MemberService {
	
	//로그인 페이지
	ModelAndView loginPage(HttpSession session);
	
	//회원가입 페이지
	ModelAndView joinPage();
	
	//회원정보수정 페이지
	ModelAndView memberModifyPage();
	
	//회원탈퇴 페이지
	ModelAndView memberSecessionPage();
	
	//회원정보 조회
	ModelAndView memberSelect();
	
	//로그인
	ModelAndView memberMaching(MemberDTO dto,HttpSession session);
	
	//회원가입
	ModelAndView memberJoin(MemberDTO dto);
	
	//회원정보수정
	ModelAndView memberModify(HttpSession session, HttpServletRequest req);
	
	//회원탈퇴
	ModelAndView memberSecession(HttpSession session);
	
	//로그아웃
	ModelAndView logout(HttpSession session);
}