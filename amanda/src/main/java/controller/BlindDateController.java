package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlindDateController {
		
	@RequestMapping("blinddate/blindDate")
	public ModelAndView blindDate(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blinddate/blindDate");
		return mav;
	}
	
	@RequestMapping("appraisal/appraisal")
	public ModelAndView appraisal(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("appraisal/appraisal");
		return mav;
	}
	
}
