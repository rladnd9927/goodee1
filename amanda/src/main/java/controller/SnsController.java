package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SnsController {
	
	@RequestMapping("sns/snsmain")
	public ModelAndView snsmain(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sns/snsmain");
		return mav;
	}
	
}
