package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.SemiUser;
import logic.SemiUserService;

public class SemiUserController {
	@Autowired
	private SemiUserService semiuserService;
	
	 @RequestMapping("user/blindDate")
	   public ModelAndView blindDate(){
		   ModelAndView mav = new ModelAndView();
		   List<SemiUser> semiuserList = semiuserService.getSemiUser();
		   mav.addObject("semiuserList",semiuserList);
		   mav.addObject(semiuserList);
		   return mav;
		}
}
