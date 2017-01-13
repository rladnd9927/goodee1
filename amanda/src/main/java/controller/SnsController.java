package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import exception.LoginRequiredException;
import exception.PasswordFailException;
import logic.Reply;
import logic.Sns;
import logic.SnsService;
import logic.User;

@Controller
public class SnsController {
	@Autowired
	private SnsService snsService;
	
	@RequestMapping("sns/snsmain")//��� �ȷο����� ���� �� ��Ÿ������. (SNS����� ��� ������ ��ȸ)
	public ModelAndView snsmain(HttpSession session){
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER");
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdate.format(new Date());
		if(loginUser == null) {
	         throw new LoginRequiredException();
	    }
		
		List<Sns> snsList = new ArrayList<Sns>();
		snsList = snsService.getList(loginUser.getM_number()); //sns����� ��� �Խù� ������ �����ðǵ�, ���� �α��� ������ ������ȣ�� �̿��Ͽ�, ���ƿ� �ѻ���� �Խù��� sns��񿡼� �����´�.
		
		mav.addObject("today", today);
		mav.addObject("snsList",snsList);
		mav.addObject("loginUser",loginUser);
		return mav;
	}
	@RequestMapping("sns/othersns") //snsmain ��ܿ��� "�������ƿ� �� ȸ���� sns�Խù�"�� ������ ���, �� requestmapping���� ����
	public ModelAndView otherssns(HttpSession session){
		ModelAndView mav = new ModelAndView();
		List<Integer> m_numberList = new ArrayList<Integer>(); //���ƿ� �� ȸ���� m_number�� �޾ƿ� ����
		List<Sns> snsList = new ArrayList<Sns>(); //���õ� ȸ���� sns�Խù� ������ ����.

		User loginUser = (User)session.getAttribute("USER");
		
		m_numberList = snsService.getOthersNum(loginUser.getM_number()); //�α����� ������ ȸ����ȣ�� �̿��Ͽ�, ���ƿ��� ȸ���� ȸ����ȣ���� �����´�.
		
		for(int i = 0 ; i<m_numberList.size(); i++){
			snsList.addAll(snsService.getList(m_numberList.get(i))); //���� ���ƿ��� ȸ���� ȸ����ȣ�� �����ͼ�, �� ��ȣ�� sns��񿡼� �Խù� ����� �̾Ƽ� snsList�� �߰��Ѵ�.
		}
		
		Collections.sort(snsList,new Comparator<Sns>() { //�ٸ� ȸ���� sns����Ʈ�� ��¥,�ð� �ֽź��� ����.
			public int compare(Sns o1, Sns o2) {
				return o2.getSns_date().compareTo(o1.getSns_date());
			}
		});
		mav.addObject("loginUser",loginUser);
		mav.addObject("snsList",snsList);
		return mav;
	}
	@RequestMapping("sns/snsdetail")
	public ModelAndView snsdetail(HttpSession session, int sns_no){
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER");
		Sns snsdetail = snsService.detail(sns_no);
		List<Reply> replyList = snsService.replyList(sns_no);
		
		mav.addObject("replyList",replyList);
		mav.addObject("snsdetail",snsdetail);
		mav.addObject("loginUser",loginUser);
		return mav;
	}
	
	@RequestMapping("sns/snsreg")
	public ModelAndView snsreg(HttpSession session){
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER");
		mav.addObject(new Sns());
		mav.addObject("loginUser",loginUser);
		mav.setViewName("sns/snsreg");
		return mav;
	}

	@RequestMapping("sns/snswrite")
	public ModelAndView write(@Valid Sns sns, BindingResult bindingResult, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("sns/snsreg");
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		snsService.write(sns,request);
		mav.setViewName("redirect:/sns/snsmain.do");
		return mav;
	}
	
	@RequestMapping("sns/snsmodify")
	public ModelAndView snsmodify(@Valid Sns sns, BindingResult bindingResult, HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("sns/snsmodifyForm");
		User loginUser = (User)session.getAttribute("USER");
		List<Reply> replyList = snsService.replyList(sns.getSns_no());
		
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			mav.addObject("snsdetail",snsService.detail(sns.getSns_no()));
			mav.addObject("replyList",replyList);
			return mav;
		}

		if(!loginUser.getM_email().equals((snsService.getUserbyNum(sns.getM_number())).getM_email())){ //�α��� ������ sns������ �ٸ��ٸ�? -> ���� �Ұ��ϰ�..
			mav.setViewName("sns/snsmodifyForm");
			bindingResult.reject("error.update.sns");
			mav.getModel().putAll(bindingResult.getModel());
			mav.addObject("snsdetail",snsService.detail(sns.getSns_no()));
			mav.addObject("replyList",replyList);
			return mav;
		}
		//������ ���� ���ε� �� ������ ����
		if(sns.getSns_file().isEmpty()){
			sns.setFileUrl(request.getParameter("file2"));
		}else{//���� ���ε带 �ٽ���
			sns.setFileUrl(sns.getSns_file().getOriginalFilename());
		}
		snsService.update(sns,request);
		mav.setViewName("redirect:list.shop");
		mav.addObject("sns",sns);
		mav.addObject("loginUser",loginUser);
		return mav;
	}
	
	@RequestMapping("sns/snsmodifyForm")
	public ModelAndView snsmodifyForm(int sns_no){
		ModelAndView mav = new ModelAndView();
		Sns sns = snsService.detail(sns_no);
		mav.addObject("sns",sns);
		
		return mav;
	}
	
	@RequestMapping("sns/snsdelete")
	public ModelAndView snsdelete(int sns_no, HttpSession session){
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER");
		List<Reply> replyList = snsService.replyList(sns_no);
		
		if(!loginUser.getM_email().equals((snsService.getUserbyNum(sns_no)).getM_email())){ //�α��� ������ sns������ �ٸ��ٸ�? -> ���� �Ұ��ϰ�..
			mav.setViewName("sns/snsdetail");
			mav.addObject("snsdetail",snsService.detail(sns_no));
			mav.addObject("replyList",replyList);
			return mav;
		}
		
		snsService.delete(sns_no);
		mav.setViewName("redirect:snsmain.do");
		return mav;
	}
}
