package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import dao.mapper.UserMapper;
import exception.AdminRequiredException;
import exception.LoginRequiredException;
import exception.MailEmptyException;
import exception.PasswordFailException;
import logic.Board;
import logic.IdealType;
import logic.IdealTypeService;
import logic.Item;
import logic.ItemService;
import logic.Mail;
import logic.Member;
import logic.Sale;
import logic.SaleItem;
import logic.SemiUser;
import logic.SemiUserService;
import logic.ShopService;
import logic.User;
import logic.UserProfile;
import logic.UserService;

@Controller
public class UserController {

	private final String naverid ="";
	private final String naverpw = "";

	@Autowired
	private ShopService shopService;

	@Autowired
	private UserService userService;

	@Autowired
	private ItemService itemService;
<<<<<<< HEAD

	@RequestMapping("user/userList")
=======
	
	@Autowired
	private IdealTypeService idealtypeService;
	
	   @RequestMapping("user/userList")
>>>>>>> branch 'master' of https://github.com/rladnd9927/goodee1.git
	public ModelAndView userList(String column, String find, HttpServletRequest request){
<<<<<<< HEAD
		List<User> userList = userService.getUser();

		List<UserProfile> userProfile = new ArrayList<UserProfile>();
		for(int i =0; i<userList.size(); i++){
			userProfile.add(userService.getUserProfile(userList.get(i).getM_number()));
		}

		if(column == null || column.equals("")) column = null;
		if(find == null || find.equals("")) find = null;
		if(column == null) find = null;
		if(find == null) column = null;
		if(find != null && request.getMethod().equalsIgnoreCase("GET")){
			try{
				find = new String(find.getBytes("8859_1"),"euc-kr");
			}catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
		}
		ModelAndView mav = new ModelAndView();
		List<User> userCount = userService.listFind(column,find);
		mav.addObject("userList",userList);
		mav.addObject("userProfile",userProfile);
		mav.addObject("userCount",userCount);
		mav.addObject("find",find);
		System.out.println(column +", " +find);
		System.out.println(userCount);
		return mav;
=======
	   List<User> userList = userService.getUser();
	   
	   List<UserProfile> userProfile = new ArrayList<UserProfile>();
	   for(int i =0; i<userList.size(); i++){
		   userProfile.add(userService.getUserProfile(userList.get(i).getM_number()));
	   }
	   
	   if(column == null || column.equals("")) column = null;
	   if(find == null || find.equals("")) find = null;
	   if(column == null) find = null;
	   if(find == null) column = null;
	   if(find != null && request.getMethod().equalsIgnoreCase("GET")){
	   	try{
	   		find = new String(find.getBytes("8859_1"),"euc-kr");
	   	}catch(UnsupportedEncodingException e){
	   		e.printStackTrace();
	   	}
	   }
	   ModelAndView mav = new ModelAndView();
       List<User> userCount = userService.listFind(column,find);
       mav.addObject("userList",userList);
	   mav.addObject("userProfile",userProfile);
       mav.addObject("userCount",userCount);
       mav.addObject("find",find);
       return mav;
>>>>>>> branch 'master' of https://github.com/rladnd9927/goodee1.git
	}
	
<<<<<<< HEAD
	@RequestMapping("user/userlist2")
	public ModelAndView userlist2(){
		ModelAndView mav = new ModelAndView("user/userlist2");
		List<User> chat = userService.userlist();
		mav.addObject("userlist", chat);
		return mav;
	}

=======
    @RequestMapping("user/userlist2")
    public ModelAndView userlist2(){
       ModelAndView mav = new ModelAndView("user/userlist2");
       List<User> chat = userService.userlist();
       mav.addObject("userlist", chat);
       return mav;
    }
	   
>>>>>>> branch 'master' of https://github.com/rladnd9927/goodee1.git
	@RequestMapping("user/userDetail")
	public ModelAndView userDetail(int m_number){
		ModelAndView mav = new ModelAndView();
		UserProfile userProfile = userService.getUserProfile(m_number);
		mav.addObject(userProfile);
		return mav;
	}
	@RequestMapping("user/main")
	public ModelAndView main(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	//알림창
<<<<<<< HEAD
	@RequestMapping("user/alert")
	public ModelAndView alert(){
		ModelAndView mav = new ModelAndView("user/alert");
		return mav;
	}
=======
	   @RequestMapping("user/alert")
	   public ModelAndView alert(){
	      ModelAndView mav = new ModelAndView("user/alert");
	      return mav;
	   }
	   
	   //좋아요를 눌렀을때.
	   @RequestMapping("user/likelist")
	   public ModelAndView likelist(int userNum, HttpSession session){
		  User myNum = (User)session.getAttribute("USER");
	      ModelAndView mav = new ModelAndView();  
	      
	      //내가 좋아요를 누르기 전에 내가 좋아요를 누르려는 사람이 이미 나를 좋아요를 눌렀는지 안눌렀는지 테스트.
	      String bb = userService.aer(userNum, myNum);
	      
	      //이미 좋아요를 눌렀는지 테스트 1이 리턴되서 aa에 들어가면 이미 좋아요를 눌렀다는 뜻.
	      String aa = userService.ser(userNum, myNum);
	      
	      String cc= userService.cer(userNum, myNum);
	      
>>>>>>> branch 'master' of https://github.com/rladnd9927/goodee1.git

<<<<<<< HEAD
	//좋아요를 눌렀을때.
	@RequestMapping("user/likelist")
	public ModelAndView likelist(int userNum, HttpSession session){
		System.out.println(userNum+"유저아이디"); 
		User myNum = (User)session.getAttribute("USER");
		ModelAndView mav = new ModelAndView();  
=======
	      //이미 좋아요 눌럿는데도 해제안되서 한번 검토
		  if(cc!=null){  
			  userService.nolist(userNum, myNum);
		      return new ModelAndView("chat/alert");     	  
		      
	      }
	      //상대가 나를 좋아요 누르지 않았을때
	      if(bb==null){
	         //내가 상대를 이미 좋아요늘 눌렀는지 안눌렀는지 
	         //널일경우 안눌렀음. 
	         if(aa==null){   
	         //고유번호 생성
	            int c_number = (int)(Math.random() * 1000 + 1);
	            //좋아요 테이블에 상대추가.
	            List<User> chat = userService.likelist(userNum, myNum,c_number);
	            mav.addObject("userlist", chat);
	            mav.setViewName("redirect:/user/userlist2.do");
	            return new ModelAndView("chat/alert2"); 
	             
	         //내가 좋아요룰 이미 누른상태일때. 
	         }else{
	            //likelist2는 좋아요 해제. 
	            List<User> chat = userService.likelist2(userNum, myNum);
	            mav.addObject("userlist", chat);
	            mav.setViewName("redirect:/user/userlist2.do");
	            return new ModelAndView("chat/alert");
	         }
	      //상대가 나를 좋아요 눌렀을때
	      }else{
	    	 int m_like = userService.m_like(userNum, myNum);
	    	 
	    	 //i_like_member 테이블에 m_like 1 추가.
	         List<User> chat = userService.likelist3(userNum, myNum,m_like);
	         mav.addObject("userlist", chat);
	         mav.setViewName("redirect:/user/userlist2.do");
	         return new ModelAndView("chat/alert2"); 
	      }
	   }
>>>>>>> branch 'master' of https://github.com/rladnd9927/goodee1.git

		//내가 좋아요를 누르기 전에 내가 좋아요를 누르려는 사람이 이미 나를 좋아요를 눌렀는지 안눌렀는지 테스트.
		String bb = userService.aer(userNum, myNum);

		//이미 좋아요를 눌렀는지 테스트 1이 리턴되서 aa에 들어가면 이미 좋아요를 눌렀다는 뜻.
		String aa = userService.ser(userNum, myNum);
		//상대가 나를 좋아요 누르지 않았을때
		if(bb==null){
			//내가 상대를 이미 좋아요늘 눌렀는지 안눌렀는지 
			//널일경우 안눌렀음. 
			if(aa==null){   
				//고유번호 생성
				int c_number = (int)(Math.random() * 1000 + 1);
				System.out.println("ㄴㄴ");
				//좋아요 테이블에 상대추가.
				List<User> chat = userService.likelist(userNum, myNum,c_number);
				mav.addObject("userlist", chat);
				mav.setViewName("redirect:/user/userlist2.do");
				return new ModelAndView("chat/alert2"); 

				//내가 좋아요룰 이미 누른상태일때. 
			}else{
				System.out.println("ㅇㅇ");
				//likelist2는 좋아요 해제. 
				List<User> chat = userService.likelist2(userNum, myNum);
				mav.addObject("userlist", chat);
				mav.setViewName("redirect:/user/userlist2.do");
				return new ModelAndView("chat/alert");
			}
			//상대가 나를 좋아요 눌렀을때
		}else{
			List<User> chat = userService.likelist(userNum, myNum);
			mav.addObject("userlist", chat);
			mav.setViewName("redirect:/user/userlist2.do");
			return new ModelAndView("chat/alert2"); 
		}
	}

	@RequestMapping("user/nolist")
	public ModelAndView nolist(int userNum, HttpSession session){
		User myNum = (User)session.getAttribute("USER");
		ModelAndView mav = new ModelAndView();
		List<User> chat = userService.nolist(userNum, myNum);
		mav.addObject("userlist", chat);
		mav.setViewName("redirect:/user/mypage2.do");
		return new ModelAndView("chat/alert");
	} 

	//mypage 컨트롤러
	@RequestMapping("user/mypage2")
	public ModelAndView mypage2 (HttpSession session){
		ModelAndView mav = new ModelAndView("user/mypage2");
		User myNum = (User)session.getAttribute("USER");
		List<Member> chat = userService.mypage(myNum);
		List<Member> chat2 = userService.youpage(myNum);
		List<User> userList = userService.getUser();
		mav.addObject("userList",userList);
		mav.addObject("mypage", chat); 
		mav.addObject("youpage", chat2);   
		return mav; 
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 *    //유저리스트폼
   @RequestMapping("user/userlist")
   public ModelAndView userlist(){
      ModelAndView mav = new ModelAndView("user/userlist");
      List<ChatUser> chat = chatService.userlist();
      mav.addObject("userlist", chat);
      return mav;
   }
	 */

	/*@RequestMapping("user/listsearch")
	public ModelAndView listsearch(Integer pageNum, String column, String find, HttpServletRequest request){
		if(column == null || column.equals("")) column = null;
		if(find == null || find.equals("")) find = null;
		if(column == null) find = null;
		if(find == null) column = null;
		if(find != null && request.getMethod().equalsIgnoreCase("GET")){
			try{
				find = new String(find.getBytes("8859_1"),"euc-kr");
			}catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
		}

		ModelAndView mav = new ModelAndView();
//		int limit = 10;
//		int listcount = boardService.boardCount(column,find);
//		List<Board> boardlist = boardService.list(pageNum,limit,column,find);
//		int maxpage = (int)((double)listcount/limit + 0.95);
//		int startpage=(((int)(pageNum/10.0 + 0.9)) -1) *10 +1;
//		int endpage = startpage + limit -1;
//		if(endpage > maxpage) endpage = maxpage;
//		int boardnum = listcount - ((pageNum - 1) * limit);
//		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
//		String today = sdate.format(new Date());
//		mav.addObject("today",today);
//		mav.addObject("pageNum",pageNum);
//		mav.addObject("maxpage",maxpage);
//		mav.addObject("startpage",startpage);
//		mav.addObject("endpage",endpage);
//		mav.addObject("listcount",listcount);
//		mav.addObject("boardlist",boardlist);
//		mav.addObject("boardnum",boardnum);
//		mav.addObject("find",find);
		return mav;
	}*/

	/////login/////////
	@RequestMapping("user/loginForm")
	public ModelAndView loginForm(){
		ModelAndView mav = new ModelAndView();
		mav.addObject(new User());
		return mav;
	}

	@RequestMapping("user/login")
	public ModelAndView login(@Valid User user, BindingResult bindingResult, HttpSession session){
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/rladnd9927/goodee1.git
		User loginUser = userService.getUserByIdPw(user);
		if(loginUser == null){
			bindingResult.reject("error.login.userId");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
<<<<<<< HEAD
		session.setAttribute("USER", loginUser);

=======
		session.setAttribute("USER", loginUser); 
>>>>>>> branch 'master' of https://github.com/rladnd9927/goodee1.git
		mav.addObject("user",loginUser);
		mav.setViewName("user/main");

		return mav;
	}
	///////////
	@RequestMapping("user/logout")
	public ModelAndView logout(HttpSession session){
		ModelAndView mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("redirect:loginForm.do");
		return mav;
		//return loginForm();
	}

	@RequestMapping("user/joinForm1")
	public ModelAndView joinForm1(){
		ModelAndView mav = new ModelAndView();
		SemiUser semiuser = new SemiUser();
		mav.addObject("semiuser",semiuser);		
		return mav;
	}
	@RequestMapping("user/join1")
	public ModelAndView join1(@Valid SemiUser semiuser, BindingResult bindingResult){
		ModelAndView mav = new ModelAndView();
		
		System.out.println(semiuser.getS_email());
		if(bindingResult.hasErrors()){
			bindingResult.reject("error.input.user");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		
		UserProfile userprofile = new UserProfile();
		semiuser.setM_number(userService.getNum()+1);
		userprofile.setSemiuser(semiuser);
		
		SemiUser a = userService.duplicateUser(semiuser.getS_email());
		if(a != null) {
//			bindingResult.reject("error.duplicate.user"); 	
			return new ModelAndView("user/alert");
		} else {
		mav.addObject("userprofile",userprofile);
		mav.setViewName("user/joinForm2");
		return mav;
		}
	}

	@RequestMapping("user/joinForm2")
	public ModelAndView joinForm2(SemiUser semiuser, UserProfile userprofile, BindingResult bindingResult, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			userprofile.setM_birthday(sf.parse("1980-01-01"));
		}catch(ParseException e){
			e.printStackTrace();
		}
		userprofile.setSemiuser(semiuser);
		userprofile.setM_number(userService.getNum());
		mav.addObject("userprofile",userprofile);

		/*if(bindingResult.hasErrors()){
			bindingResult.reject("error.input.user");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}*/
		try{
			userService.createUser(userprofile,request);
		}catch(DuplicateKeyException e){
			e.printStackTrace();
			bindingResult.reject("error.duplicate.user");
			return mav;
		}
		mav.setViewName("redirect:loginForm.do");
		return mav;
	}

	//	@RequestMapping("user/join2")
	//	public ModelAndView join2(@Valid UserProfile userprofile, BindingResult bindingResult,HttpServletRequest request){
	//		System.out.println("gg");
	//		ModelAndView mav = new ModelAndView();
	//		if(bindingResult.hasErrors()){
	//			bindingResult.reject("error.input.user");
	//			mav.getModel().putAll(bindingResult.getModel());
	//			return mav;
	//		}
	//		try{
	//			userService.createUser(userprofile,request);
	//		}catch(DuplicateKeyException e){
	//			bindingResult.reject("error.duplicate.user");
	//			return mav;
	//		}
	//		mav.setViewName("user/loginForm.do");
	//		mav.addObject("userprofile",userprofile);
	//		System.out.println(mav);
	//		return mav;
	//	}
	//	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	/*   @RequestMapping("user/userEntry")
   public ModelAndView userEntry(@Valid User user, BindingResult bindingResult){
	   ModelAndView mav = new ModelAndView();
	   if(bindingResult.hasErrors()){
		   bindingResult.reject("error.input.user");
		   mav.getModel().putAll(bindingResult.getModel());
		   return mav;
	   }
	   try{
		   shopService.createUser(user);
	   }catch(DuplicateKeyException e){
		   bindingResult.reject("error.duplicate.user");
		   return mav;
	   }
	   mav.setViewName("user/login");
	   mav.addObject("user",user);
	   return mav;
   }*/

	/*@RequestMapping("user/mypage")
	public ModelAndView mypage(String m_email){
		ModelAndView mav = new ModelAndView();
		User user = userService.getUserById(m_email);
		List<User> userList = userService.getUser();
		mav.addObject("userList",userList);
			   for(Sale sale : salelist){
		   List<SaleItem> saleItemList = shopService.saleItemList(sale.getSaleId());
		   for(SaleItem sitem : saleItemList){
			   Item item = itemService.getItemList(sitem.getItemId());
			   sitem.setItem(item);
		   }
		   sale.setSaleItemList(saleItemList);
<<<<<<< HEAD
=======
	   }*/
	   //mav.addObject("salelist",salelist);
	   //mav.addObject("userList",userList);
	   return mav;
   }
   
//   @RequestMapping("user/userProfile")
//   public ModelAndView userProfile(){
//	   ModelAndView mav = new ModelAndView();
//	   return mav;
//   }
   
   @RequestMapping("user/idealtype") //현재 내가 설정한 이상형 보여주기
   public ModelAndView idealtype(HttpSession session){
		ModelAndView mav = new ModelAndView("user/idealtype");
		User loginUser = (User)session.getAttribute("USER");
		int loginUserNumber = loginUser.getM_number();//로그인 번호 빼오기
		IdealType idealType = idealtypeService.getIdealType(loginUserNumber);//로그인 유저가 설정한 이상형 테이블을 검색
		mav.addObject("idealType",idealType);
		return mav; 
   }
   
   @RequestMapping("user/idealtype2") //내 이상형 편집
   public ModelAndView idealtype2(HttpSession session){
		ModelAndView mav = new ModelAndView("user/idealtype2");
		User loginUser = (User)session.getAttribute("USER");
		int loginUserNumber = loginUser.getM_number();
		IdealType idealType = idealtypeService.getIdealType(loginUserNumber);
		mav.addObject("idealType",idealType);
		return mav; 
   }
   
   @RequestMapping("user/idealtype_update") //편집한 이상형 업데이트 & 일치하는 이상형을 리스트로 출력
   public ModelAndView idealtype_update(HttpSession session, UserProfile userProfile, IdealType idealType, BindingResult bindingResult){
	   ModelAndView mav = new ModelAndView("user/idealtype_update");
		User loginUser = (User)session.getAttribute("USER");
		List<UserProfile> idealList = idealtypeService.getIdealList(idealType.getI_height());
		int loginUserNumber = loginUser.getM_number();
		idealtypeService.idealUpdate(loginUserNumber, idealType);
		mav.addObject("idealList",idealList);
		mav.setViewName("user/userList");
		return mav;
   }
   
   @RequestMapping("user/mailForm")
   public ModelAndView mailForm(String[] idchks){
	   ModelAndView mav = new ModelAndView();
	   if(idchks == null || idchks.length == 0){
		   throw new MailEmptyException();
>>>>>>> branch 'master' of https://github.com/rladnd9927/goodee1.git
	   }
		mav.addObject("salelist",salelist);
		mav.addObject("userList",userList);
		return mav;
	}*/
		
	@RequestMapping("user/admin")
	public ModelAndView admin(HttpSession session, String column, String find, HttpServletRequest request){
		User loginUser = (User)session.getAttribute("USER");
		if(loginUser == null){
			throw new LoginRequiredException();
		}
		if(!loginUser.getM_email().equals("admin")){
			throw new AdminRequiredException();
		}
		ModelAndView mav = new ModelAndView();
		List<User> userList = userService.getUser();

		List<UserProfile> userProfile = new ArrayList<UserProfile>();
		for(int i =0; i<userList.size(); i++){
			userProfile.add(userService.getUserProfile(userList.get(i).getM_number()));
		}

		if(column == null || column.equals("")) column = null;
		if(find == null || find.equals("")) find = null;
		if(column == null) find = null;
		if(find == null) column = null;
		if(find != null && request.getMethod().equalsIgnoreCase("GET")){
			try{
				find = new String(find.getBytes("8859_1"),"euc-kr");
			}catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
		}
		List<User> userCount = userService.listFind(column,find);
		mav.addObject("userList",userList);
		mav.addObject("userProfile",userProfile);
		mav.addObject("userCount",userCount);
		mav.addObject("find",find);
		return mav;
	}
	
	@RequestMapping("user/updateForm")
	public ModelAndView updateForm(int m_number){
		ModelAndView mav = new ModelAndView();
		User updateuser = userService.getUpdateUser(m_number);
		UserProfile updateuserProfile = userService.getUpdateUserProfile(m_number);
		updateuserProfile.setUser(updateuser);
		mav.addObject(updateuser);
		mav.addObject(updateuserProfile);
		return mav;
	}
	
	@RequestMapping("user/update") //편집한 이상형 업데이트 & 일치하는 이상형을 리스트로 출력
	   public ModelAndView update(HttpSession session, 
			   UserProfile userProfile, User user, 
			   BindingResult bindingResult, HttpServletRequest request, int m_number){
		ModelAndView mav = new ModelAndView("user/updateForm");
		mav.addObject("userProfile",userProfile);
		
		if(userProfile.getUser().getM_password().equals("") || userProfile.getUser().getM_password() == null){
			return mav;
		}
		
		try{
			userService.updateUserProfile(userProfile,request);
		}catch(DuplicateKeyException e){
			e.printStackTrace();
			bindingResult.reject("error.duplicate.user");
			return mav;
		}
		mav.setViewName("redirect:admin.do");
		return mav;
	}
	/*@RequestMapping("user/idealtype_update") //편집한 이상형 업데이트 & 일치하는 이상형을 리스트로 출력
	   public ModelAndView idealtype_update(HttpSession session, UserProfile userProfile, IdealType idealtype, BindingResult bindingResult){
	      ModelAndView mav = new ModelAndView("user/idealtype_update");
	      User loginUser = (User)session.getAttribute("USER");
	      List<UserProfile> idealList = idealtypeService.getIdealList(idealtype.getI_height());
	      int loginUserNumber = loginUser.getM_number();
	      idealtypeService.idealUpdate(loginUserNumber, idealtype);
	      mav.addObject("idealList",idealList);
	      mav.setViewName("user/userList");
	      return mav;
	   }*/
	/*@RequestMapping("user/userDetail")
	public ModelAndView userDetail(int m_number){
		ModelAndView mav = new ModelAndView();
		UserProfile userProfile = userService.getUserProfile(m_number);
		mav.addObject(userProfile);
		return mav;
	}*/
	/*@RequestMapping("user/admin")
	public ModelAndView admin(HttpSession session, String column, String find, HttpServletRequest request){
		User loginUser = (User)session.getAttribute("USER");
		if(loginUser == null){
			throw new LoginRequiredException();
		}
		if(!loginUser.getM_email().equals("admin")){
			throw new AdminRequiredException();
		}
		ModelAndView mav = new ModelAndView();
		List<User> userList = userService.getUser();
		mav.addObject("userList",userList);
		mav.addObject(userList);
		return mav;
	}*/
	/*
   @RequestMapping("user/blindDate")
   public ModelAndView blindDate(){
	   ModelAndView mav = new ModelAndView();
	   List<User> userList = userService.getUser();
	   mav.addObject("userList",userList);
	   mav.addObject(userList);
	   return mav;
	}


   @RequestMapping("user/blindDate")
   public ModelAndView blindDate(){
	   ModelAndView mav = new ModelAndView();
	   List<SemiUser> semiuserList = semiuserService.getSemiUser();
	   mav.addObject("semiuserList",semiuserList);
	   mav.addObject(semiuserList);
	   return mav;
	}
	 */

	@RequestMapping("user/mailForm")
	public ModelAndView mailForm(String[] idchks){
		ModelAndView mav = new ModelAndView();
		if(idchks == null || idchks.length == 0){
			throw new MailEmptyException();
		}
		List<User> userList = shopService.getUser(idchks);
		mav.addObject("userList",userList);
		return mav;
	}

	@RequestMapping("/user/mail")
	public ModelAndView mail(Mail mail){
		ModelAndView mav = new ModelAndView("user/mailsuccess");
		adminMailSend(mail);
		return mav;
	}

	private void adminMailSend(Mail mail) {
		MyAuthenticator auth = new MyAuthenticator(naverid,naverpw);
		Properties prop = new Properties();
		FileInputStream fis;
		try{
			File pr = new File("C:/MyWork/spring/workspace/shop-4/mail.properties");
			fis = new FileInputStream(pr);
			prop.load(fis);
		}catch(IOException e){
			e.printStackTrace();
		}
		Session session = Session.getInstance(prop,auth);
		MimeMessage msg = new MimeMessage(session);
		try{
			msg.setFrom(new InternetAddress(naverid));
			List<InternetAddress> addrs = new ArrayList<InternetAddress>();
			String[] emails = mail.getRecipient().split(",");
			for(int i=0; i<emails.length;i++){
				try{
					addrs.add(new InternetAddress(new String(emails[i].getBytes("euc-kr"),"8859_1")));
				}catch(UnsupportedEncodingException e){
					e.printStackTrace();
				}
			}
			InternetAddress[] arr = new InternetAddress[emails.length];
			for(int i=0; i<addrs.size();i++){
				arr[i] = addrs.get(i);
			}
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO,arr);
			msg.setSubject(mail.getTitle());
			MimeMultipart multipart = new MimeMultipart();
			MimeBodyPart message = new MimeBodyPart();
			message.setContent(mail.getContents(),mail.getMtype());
			multipart.addBodyPart(message);
			if(mail.getFile1() != null && !mail.getFile1().isEmpty()){
				multipart.addBodyPart(bodyPart(mail));
			}
			msg.setContent(multipart);
			Transport.send(msg);
		}catch(MessagingException me){
			me.printStackTrace();
		}
	}

	private BodyPart bodyPart(Mail mail) {
		MimeBodyPart body = new MimeBodyPart();
		FileOutputStream fos = null;
		try{
			String filename="D:/shop-4/mail/" + mail.getFile1().getOriginalFilename();
			File f1= new File(filename);
			fos = new FileOutputStream(f1);
			InputStream in = mail.getFile1().getInputStream();
			int len;
			byte[] buf = new byte[4096];
			while((len = in.read(buf)) != -1){
				fos.write(buf, 0, len);
			}
			body.attachFile(f1);
			body.setFileName(new String(f1.getName().getBytes("euc-kr"),"8859_1"));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fos != null){
					fos.flush(); fos.close();
				}
			}catch(IOException e){}
		}
		return body;
	}

	public final class MyAuthenticator extends Authenticator{
		private String id;
		private String pw;
		public MyAuthenticator(String id, String pw){
			this.id = id;
			this.pw = pw;
		}
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(id,pw);
		}
	}
}
