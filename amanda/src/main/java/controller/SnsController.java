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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import exception.LoginRequiredException;
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
		if(loginUser == null) {
	         throw new LoginRequiredException();
	    }
		
		List<Sns> snsList = new ArrayList<Sns>();
		snsList = snsService.getList(loginUser.getM_number()); //sns����� ��� �Խù� ������ �����ðǵ�, ���� �α��� ������ ������ȣ�� �̿��Ͽ�, ���ƿ� �ѻ���� �Խù��� sns��񿡼� �����´�.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		mav.addObject("today",today);
		mav.addObject("snsList",snsList);
		mav.addObject("loginUser",loginUser);
		return mav;
	}
	
	@RequestMapping("sns/othersnslist") //snsmain ��ܿ��� "�������ƿ� �� ȸ���� sns�Խù�"�� ������ ���, �� requestmapping���� ����
	public ModelAndView othersnslist(HttpSession session){
		ModelAndView mav = new ModelAndView();
		List<Integer> m_numberList = new ArrayList<Integer>(); //���ƿ� �� ȸ���� m_number�� �޾ƿ� ����
		List<Sns> snsList = new ArrayList<Sns>(); //���õ� ȸ���� sns�Խù� ������ ����.

		User loginUser = (User)session.getAttribute("USER");
		if(loginUser == null) {
	         throw new LoginRequiredException();
	    }
		m_numberList = snsService.getOthersNum(loginUser.getM_number()); //�α����� ������ ȸ����ȣ�� �̿��Ͽ�, ���ƿ��� ȸ���� ȸ����ȣ���� �����´�.
		
	
		for(int i = 0 ; i<m_numberList.size(); i++){
			for(int j = 0 ; j < snsService.getList(m_numberList.get(i)).size(); j++){
				snsList.add(snsService.getList(m_numberList.get(i)).get(j)); //���� ���ƿ��� ȸ���� ȸ����ȣ�� �����ͼ�, �� ��ȣ�� sns��񿡼� �Խù� ����� �̾Ƽ� �Խù� ��ü���� snsList�� ���
			}
			
		}
		
		Collections.sort(snsList,new Comparator<Sns>() { //�ٸ� ȸ���� sns����Ʈ�� ��¥,�ð� �ֽź��� ����.
			public int compare(Sns o1, Sns o2) {
				return o2.getSns_date().compareTo(o1.getSns_date());
			}
		});
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		mav.addObject("today",today);
		mav.addObject("snsList",snsList);
		mav.addObject("loginUser",loginUser);
		return mav;
	}
	@RequestMapping("sns/snsdetail")
	public @ResponseBody List<Object> snsdetail(int sns_no, int m_number){
		Sns sns = snsService.detail(sns_no,m_number);
		List<Reply> replyList = snsService.replyList(sns_no,m_number);
		List<Object> responseObj = new ArrayList<Object>();
		String snsjson=null;
		String snsreplyList=null;
		try {
			snsjson = snsService.ObjectToJSONString(sns);
			snsreplyList = snsService.ObjectToJSONString(replyList); //sns��ü�� replyList��ü�� json String���·� ��ȯ��.
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		responseObj.add(snsjson);
		responseObj.add(snsreplyList);
		return responseObj;
	}
	
	@RequestMapping("sns/snsreg")
	public ModelAndView snsreg(HttpSession session){
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER");
		if(loginUser == null) {
	         throw new LoginRequiredException();
	    }
		Sns sns = new Sns();
		sns.setM_number(loginUser.getM_number());
		mav.addObject(sns);
		mav.addObject("loginUser",loginUser);
		mav.setViewName("sns/snsreg");
		return mav;
	}

	@RequestMapping("sns/snswrite")
	public ModelAndView snswrite(@Valid Sns sns, BindingResult bindingResult, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("sns/snsreg");
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		snsService.write(sns,request);
		mav.setViewName("redirect:snsmain.do");
		return mav;
	}
	
	@RequestMapping("sns/snsmodify")
	public ModelAndView snsmodify(@Valid Sns sns, BindingResult bindingResult, HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("sns/snsmodifyForm");
		User loginUser = (User)session.getAttribute("USER");
		List<Reply> replyList = snsService.replyList(sns.getSns_no(),sns.getM_number());
		
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			mav.addObject("snsdetail",snsService.detail(sns.getSns_no(),sns.getM_number()));
			mav.addObject("replyList",replyList);
			return mav;
		}
		
		if(!loginUser.getM_email().equals((snsService.getUserbyNum(sns.getM_number())).getM_email())){ //�α��� ������ sns������ �ٸ��ٸ�? -> ���� �Ұ��ϰ�..
			mav.setViewName("sns/snsmodifyForm");
			bindingResult.reject("error.update.sns");
			mav.getModel().putAll(bindingResult.getModel());
			mav.addObject("sns",snsService.detail(sns.getSns_no(),sns.getM_number()));
			return mav;
		}
		//������ ���� ���ε� �� ������ ����
		if(sns.getSns_picture().isEmpty()){
			sns.setFileUrl(request.getParameter("file2"));
		}else{//���� ���ε带 �ٽ���
			sns.setFileUrl(sns.getSns_picture().getOriginalFilename());
		}
		snsService.update(sns,request);
		mav.setViewName("redirect:snsmain.do");
		mav.addObject("sns",sns);
		mav.addObject("loginUser",loginUser);
		return mav;
	}
	
	@RequestMapping("sns/snsmodifyForm")
	public ModelAndView snsmodifyForm(int sns_no, int m_number){
		ModelAndView mav = new ModelAndView();
		Sns sns = snsService.detail(sns_no,m_number);
		mav.addObject("sns",sns);
		
		return mav;
	}
	
	@RequestMapping("sns/snsdelete")
	public ModelAndView snsdelete(int sns_no,int m_number, HttpSession session){
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER");
		if(!loginUser.getM_email().equals((snsService.getUserbyNum(m_number)).getM_email())){ //�α��� ������ sns������ �ٸ��ٸ�? -> ���� �Ұ��ϰ�..
			mav.setViewName("sns/snsmain");
			mav.addObject("sns",snsService.detail(sns_no,m_number));
			return mav;
		}
		
		snsService.delete(sns_no, m_number);
		mav.setViewName("redirect:snsmain.do");
		return mav;
	}
	@RequestMapping("sns/replyreg")
	public @ResponseBody List<Object> replyreg(int sns_no, String r_content, HttpSession session){
		User loginUser = (User)session.getAttribute("USER");
		int m_number = loginUser.getM_number();
		snsService.replyReg(sns_no, m_number, r_content);
		Sns sns = snsService.detail(sns_no,m_number);
		
		List<Reply> replyList = snsService.replyList(sns_no,m_number);
		List<Object> responseObj = new ArrayList<Object>();
		
		String snsjson=null;
		String snsreplyList=null;
		try {
			snsjson = snsService.ObjectToJSONString(sns);
			snsreplyList = snsService.ObjectToJSONString(replyList); //sns��ü�� replyList��ü�� json String���·� ��ȯ��.
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		responseObj.add(snsjson);
		responseObj.add(snsreplyList);
		return responseObj;
	}
	@RequestMapping("sns/replydelete")
	public ModelAndView replydelete(int sns_no,int m_number, int r_num, HttpSession session){
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER");
		
		if(loginUser.getM_number() != m_number){ //�α��� ������ sns������ �ٸ��ٸ�? -> ���� �Ұ��ϰ�..
			mav.setViewName("sns/snsmain");
			mav.addObject("sns",snsService.detail(sns_no,m_number));
			return mav;
		}
		
		snsService.replyDelete(sns_no, m_number,r_num);
		mav.setViewName("redirect:snsmain.do");
		return mav;
	}
}
