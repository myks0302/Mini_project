package org.samzo.cafe.js;

import org.springframework.web.servlet.ModelAndView;

public interface JspService {
		ModelAndView aside();
		
		ModelAndView footer();
		
		ModelAndView header();
		
		ModelAndView mainsection();
}
