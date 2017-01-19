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

import exception.SimsaException;
import logic.SemiUser;
import logic.SemiUserService;
import logic.Simsa;
import logic.User;
import logic.UserProfile;

@Controller
public class SemiUserController {
	@Autowired
	private SemiUserService semiuserService;
	
	 @RequestMapping("user/evaluate")
	   public ModelAndView evaluate(HttpSession session, SemiUser semiuser){
			ModelAndView mav = new ModelAndView();
			User loginUser = (User)session.getAttribute("USER");
			int loginUserNumber = loginUser.getM_number();
			List<SemiUser> semiuserList = semiuserService.getSemiUser(loginUserNumber);
			mav.addObject("semiuserList",semiuserList);
			mav.addObject(semiuserList);
			return mav;
	 } 
	         
	 @RequestMapping("user/semiDetail")
	 public ModelAndView semiDetail(int m_number, SemiUser semiuser, HttpSession session){
			ModelAndView mav = new ModelAndView();
			User loginUser = (User)session.getAttribute("USER");
			int loginUserNumber = loginUser.getM_number();
			Simsa simsaMember = semiuserService.getSimsaMember(m_number);
			if(simsaMember.getSimsa_number() == loginUserNumber){
				throw new SimsaException();
			}
			UserProfile semiuserProfile = semiuserService.getsemiUserProfile(m_number);
			SemiUser semiUser = semiuserService.getSemiUserByNumScore(semiuser.getM_number(), semiuser.getS_score());
			mav.addObject("semiuserProfile",semiuserProfile);
			mav.addObject("semiUser", semiUser);
			mav.addObject(semiUser);
			return mav;
	 }
	 
	  @RequestMapping("user/semi1")
		public ModelAndView semi1(SemiUser semiuser, HttpSession session){
			ModelAndView mav = new ModelAndView();
			User loginUser = (User)session.getAttribute("USER");
			int loginUserNumber = loginUser.getM_number();//���� �α��� �� ȸ���� ��ȣ�� �Ѱ���
			semiuserService.pointCountUp(semiuser); // �ɻ� ���� �ɻ��� �������� ��������
			semiuserService.semiDelete(semiuser); // ����ī��Ʈ�� 5 �̻��̸鼭 ������ 3�� �̸��� ȸ�� Ż��
			semiuserService.UpdateSimsa(semiuser.getM_number(), loginUserNumber);
			SemiUser selectOkMember = semiuserService.getOkMember(semiuser);
			if(selectOkMember != null){
				semiuserService.memberInsert(selectOkMember);
				semiuserService.idealTypeInsert(selectOkMember);
			}
			mav.addObject("selectOkMember", selectOkMember);
			mav.setViewName("redirect:evaluate.do");
			return mav;
	}
	  /*
	  @RequestMapping("user/semi1")
		public ModelAndView semi1(SemiUser semiuser){
			ModelAndView mav = new ModelAndView();
			semiuserService.pointCountUp(semiuser);
			semiuserService.semiDelete(semiuser);
			mav.setViewName("redirect:evaluate.do");
			return mav;
	}
	*/
}