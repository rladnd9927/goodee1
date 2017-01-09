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
	
}
