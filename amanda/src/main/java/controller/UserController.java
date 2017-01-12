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


import exception.AdminRequiredException;
import exception.LoginRequiredException;
import exception.MailEmptyException;
import logic.Board;
import logic.Item;
import logic.ItemService;
import logic.Mail;
import logic.Sale;
import logic.SaleItem;
import logic.SemiUser;
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
	

	 
	@RequestMapping("user/userList")
	public ModelAndView userList(){
		ModelAndView mav = new ModelAndView();
		User user = new User();
		mav.addObject(user);
		return mav;
	}
	@RequestMapping("user/main")
	public ModelAndView main(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
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
		
		User loginUser = userService.getUserByIdPw(user);
		if(loginUser == null){
			bindingResult.reject("error.login.userId");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		session.setAttribute("USER", loginUser);
		
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
		System.out.println("폼1 끝");
		return mav;
	}
	@RequestMapping("user/join1")
	public ModelAndView join1(@Valid SemiUser semiuser){
		ModelAndView mav = new ModelAndView();
		UserProfile userprofile = new UserProfile();
		userprofile.setSemiuser(semiuser);
		System.out.println("조인1 시작");
		mav.addObject("userprofile",userprofile);
		mav.setViewName("user/joinForm2");
		System.out.println(mav);
		return mav;
	}
	 
	@RequestMapping("user/joinForm2")
	public ModelAndView joinForm2(SemiUser semiuser, UserProfile userprofile,  BindingResult bindingResult, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			userprofile.setM_birthday(sf.parse("1980-01-01"));
		}catch(ParseException e){
			e.printStackTrace();
		}
		userprofile.setSemiuser(semiuser);
		/*mav.addObject("semiuser",semiuser);*/
		mav.addObject("userprofile",userprofile);
		System.out.println(userprofile);

//		if(bindingResult.hasErrors()){
//			bindingResult.reject("error.input.user");
//			System.out.println("에러셋팅");
//			mav.getModel().putAll(bindingResult.getModel());
//			return mav;
//		}
		try{
			System.out.println("DB접속");
			userService.createUser(userprofile,request);
			
		}catch(DuplicateKeyException e){
			bindingResult.reject("error.duplicate.user");
			return mav;
		}
		mav.addObject("userprofile",userprofile);
		mav.setViewName("user/loginForm.do");
		System.out.println(mav);
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
   
   @RequestMapping("user/mypage")
   public ModelAndView mypage(String id){
	   ModelAndView mav = new ModelAndView();
	   User user = shopService.getUserById(id);
	   List<Sale> salelist = shopService.saleList(id);
	   for(Sale sale : salelist){
		   List<SaleItem> saleItemList = shopService.saleItemList(sale.getSaleId());
		   for(SaleItem sitem : saleItemList){
			   Item item = itemService.getItemList(sitem.getItemId());
			   sitem.setItem(item);
		   }
		   sale.setSaleItemList(saleItemList);
	   }
	   mav.addObject("salelist",salelist);
	   mav.addObject("user",user);
	   return mav;
   }
   
   @RequestMapping("user/admin")
   public ModelAndView admin(HttpSession session){
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
	   return mav;
   }
   
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
