package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.SemiUser;
import logic.SemiUserService;
import logic.UserProfile;

@Controller
public class SemiUserController {
	@Autowired
	private SemiUserService semiuserService;
	
	 @RequestMapping("user/evaluate")
	   public ModelAndView evaluate(){
			ModelAndView mav = new ModelAndView();
			List<SemiUser> semiuserList = semiuserService.getSemiUser();
			mav.addObject("semiuserList",semiuserList);
			mav.addObject(semiuserList);
			return mav;
	 } 
	 
	 @RequestMapping("user/semiDetail")
	 public ModelAndView semiDetail(int s_number, SemiUser semiuser){
			ModelAndView mav = new ModelAndView();
			UserProfile semiuserProfile = semiuserService.getsemiUserProfile(s_number);
			mav.addObject("semiuserProfile",semiuserProfile);
			mav.addObject("semiuser",semiuser);
			return mav;
	 }
	 
	 @RequestMapping("user/semi1")
		public ModelAndView semi1(int s_number,SemiUser semiuser, BindingResult bindingResult, HttpServletRequest request, HttpSession session){
			ModelAndView mav = new ModelAndView();
			System.out.println(s_number);
			System.out.println(semiuser.getS_score());
			try{
				semiuserService.pointUp(s_number,semiuser.getS_score());
			}catch(DuplicateKeyException e){
				e.printStackTrace();
				bindingResult.reject("error.duplicate.user");
				return mav;
			}
			mav.setViewName("redirect:semiDetail.do?s_number=" + s_number);
			return mav;
	}
}