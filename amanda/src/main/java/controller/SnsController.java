package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import logic.Reply;
import logic.Sns;
import logic.SnsService;
import logic.User;

@Controller
public class SnsController {
	@Autowired
	private SnsService snsService;
	
	@RequestMapping("sns/snsmain")//모든 팔로워들의 글이 다 나타나야함. (SNS디비의 모든 정보를 조회)
	public ModelAndView snsmain(HttpSession session){
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER");
		if(loginUser == null) {
	         throw new LoginRequiredException();
	    }
		
		List<Sns> snsList = new ArrayList<Sns>();
		snsList = snsService.getList(loginUser.getM_number()); //sns디비의 모든 게시물 정보를 가져올건데, 현재 로그인 유저의 유저번호를 이용하여, 좋아요 한사람의 게시물만 sns디비에서 가져온다.
		
		mav.addObject("snsList",snsList);
		mav.addObject("loginUser",loginUser);
		return mav;
	}
	@RequestMapping("sns/otherssns") //snsmain 뷰단에서 "내가좋아요 한 회원의 sns게시물"을 눌렀을 경우, 이 requestmapping으로 연결
	public ModelAndView otherssns(HttpSession session){
		ModelAndView mav = new ModelAndView();
		List<Integer> m_numberList = new ArrayList<Integer>(); //좋아요 한 회원의 m_number를 받아올 변수
		List<Sns> snsList = new ArrayList<Sns>(); //선택된 회원의 sns게시물 정보를 저장.

		User loginUser = (User)session.getAttribute("USER");
		
		m_numberList = snsService.getOthersNum(loginUser.getM_number()); //로그인한 유저의 회원번호를 이용하여, 좋아요한 회원의 회원번호들을 가져온다.
		
		for(int i = 0 ; i<m_numberList.size(); i++){
			snsList.addAll(snsService.getList(m_numberList.get(i))); //내가 좋아요한 회원의 회원번호를 가져와서, 그 번호로 sns디비에서 게시물 목록을 뽑아서 snsList에 추가한다.
		}
		
		Collections.sort(snsList,new Comparator<Sns>() { //다른 회원들 sns리스트를 날짜,시간 최신별로 정렬.
			public int compare(Sns o1, Sns o2) {
				return o2.getSns_date().compareTo(o1.getSns_date());
			}
		});
		mav.addObject("loginUser",loginUser);
		mav.addObject("snsList",snsList);
		return mav;
	}
	@RequestMapping("sns/snsdetail")
	public ModelAndView snsdetail(HttpSession session, Integer sns_no){
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
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			mav.addObject("board",snsService.detail(sns.getSns_no()));
			return mav;
		}
//		String pass = snsService.getPassword(sns.getSns_no());
//		if(!pass.equals(sns.getPass())){
//			mav.setViewName("board/updateForm");
//			bindingResult.rejectValue("pass", "error.board.password");
//			mav.getModel().putAll(bindingResult.getModel());
//			mav.addObject("board",snsService.detail(sns.getSns_no()));
//			return mav;
//		}
		
		//수정시 새로 업로드 된 파일이 없음
		if(sns.getSns_file().isEmpty()){
			sns.setFileUrl(request.getParameter("file2"));
		}else{//파일 업로드를 다시함
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
	
	@RequestMapping("sns/snsdelete") //하루가 지나면 디비에서 삭제.
	public ModelAndView snsdelete(HttpSession session){
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER");
		
		mav.addObject("loginUser",loginUser);
		return mav;
	}
}
