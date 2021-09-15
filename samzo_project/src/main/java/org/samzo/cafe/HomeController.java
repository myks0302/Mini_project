package org.samzo.cafe;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.samzo.cafe.js.JspServiceImpl;
import org.samzo.cafe.member.MemberDTO;
import org.samzo.cafe.member.serviceImpl.MemberServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	MemberServiceImpl impl;
	
	@Autowired
	JspServiceImpl jimpl;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	//로그인 페이지
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpSession session) {
		ModelAndView mav = impl.loginPage(session);
		return mav;
	}
	
	//로그인
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView login(MemberDTO dto, HttpSession session) {
		return impl.memberMaching(dto,session);
	}
	
	//회원가입 페이지
	@RequestMapping(value = "join.do", method = RequestMethod.GET)
	public ModelAndView joinPage() {
		return impl.joinPage();
	}
	
	//회원가입
	@RequestMapping(value = "join.do", method = RequestMethod.POST)
	public ModelAndView join(MemberDTO dto) {
		return impl.memberJoin(dto);
	}
	
	//회원정보 수정 페이지
	@RequestMapping(value = "modify.do", method = RequestMethod.GET)
	public ModelAndView modifyPage() {
		return impl.memberModifyPage();
	}
	
	//회원정보 수정
	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public ModelAndView modify(HttpSession session, HttpServletRequest req) {
		return impl.memberModify(session,req);
	}
	
	//회원탈퇴 페이지
	@RequestMapping(value = "remove.do", method = RequestMethod.GET)
	public ModelAndView removePage() {
		return impl.memberSecessionPage();
	}
	
	//회원탈퇴
	@RequestMapping(value = "remove.do", method = RequestMethod.POST)
	public ModelAndView remove(HttpSession session) {
		return impl.memberSecession(session);
	}
	
	//로그아웃
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		return impl.logout(session);
	}
	
	//회원목록 조회
	@RequestMapping(value = "memberList.do", method = RequestMethod.GET)
	public ModelAndView memberList() {
		return impl.memberSelect();
	}
	
	@RequestMapping(value="aside.do",method = RequestMethod.GET)
	public ModelAndView aside() {
		
		return jimpl.aside();
		
	}
	@RequestMapping(value="footer.do",method = RequestMethod.GET)
	public ModelAndView footer() {
		
		return jimpl.footer();
		
	}
	@RequestMapping(value="header.do",method = RequestMethod.GET)
	public ModelAndView header() {
		
		return jimpl.header();
		
	}
	@RequestMapping(value="mainsection.do",method = RequestMethod.GET)
	public ModelAndView mainsection() {
		
		return jimpl.mainsection();
		
	}

}
