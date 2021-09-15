package org.samzo.cafe.js;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service("jspService")
public class JspServiceImpl implements JspService{

	@Override
	public ModelAndView aside() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("jspindexpages/aside");
		return mnv;
	}

	@Override
	public ModelAndView footer() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("jspindexpages/footer");
		return mnv;
	}

	@Override
	public ModelAndView header() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("jspindexpages/header");
		return mnv;
	}

	@Override
	public ModelAndView mainsection() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("jspindexpages/mainsection");
		return mnv;
	}

}
