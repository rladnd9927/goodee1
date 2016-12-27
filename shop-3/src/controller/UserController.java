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
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


import exception.AdminRequiredException;
import exception.LoginRequiredException;
import exception.MailEmptyException;
import logic.Item;
import logic.Mail;
import logic.Sale;
import logic.SaleItem;
import logic.ShopService;
import logic.User;

@Controller
public class UserController {
	private String naverid ="rladnd9927@naver.com";
	private String naverpw ="wkrkdyd1";
	@Autowired
	private ShopService shopService;
	@RequestMapping("user/userEntryForm")
	public ModelAndView userEntryForm(){
		ModelAndView mav = new ModelAndView("user/userEntry");
		User user= new User();
		DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			user.setBirthDay(sf.parse("1990-01-01"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mav.addObject(user);
		return mav;
	}
	
	@RequestMapping("user/userEntry")
	public ModelAndView userSubmit(@Valid User user, BindingResult bindingResult)throws Exception{
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()){
			bindingResult.reject("error.input.user");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		
		try{
			shopService.createUser(user);
			mav.setViewName("user/login");
			mav.addObject("user",user);
		}catch(DataIntegrityViolationException e){
			bindingResult.reject("error.duplicate.user");
		}
		return mav;
	}
	
	@RequestMapping("user/loginForm")
	public ModelAndView loginForm(){
		ModelAndView mav = new ModelAndView("user/login");
		
		mav.addObject(new User());
		return mav;
	}
	
	@RequestMapping("user/login")
	public ModelAndView login(@Valid User user, BindingResult bindingResult,HttpSession session){
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		try{
			User loginUser = shopService.getUserByIdPw(user.getUserId(), user.getPassword());
			session.setAttribute("USER", loginUser);
			List<Sale> salelist=shopService.saleList(user.getUserId());
			//salelist: user가 주문한 목록, sale테이블을 조회한다.
			for(Sale sale : salelist){
				//saleItemList : saleId에 속한 주문 상품의 목록이 저장되어 있음.
				List<SaleItem> saleItemList = shopService.saleItemList(sale.getSaleId());
				for(SaleItem sitem : saleItemList){
					Item item = shopService.getItemById(sitem.getItemId());
					sitem.setItem(item);
				}
				sale.setSaleItemList(saleItemList);
			}
			
			mav.setViewName("user/mypage");
			mav.addObject("user",loginUser);
			mav.addObject("salelist",salelist);
			return mav;
		}catch(EmptyResultDataAccessException e){
			bindingResult.reject("error.login.id");
			mav.getModel().putAll(bindingResult.getModel());
		}
		return mav;
	}
	
	@RequestMapping("user/mypage")
	public ModelAndView mypage(String id){
		ModelAndView mav = new ModelAndView();
		User user = shopService.getUserById(id);
		List<Sale> salelist=shopService.saleList(id);
		for(Sale sale : salelist){
			List<SaleItem> saleItemList = shopService.saleItemList(sale.getSaleId());
			for(SaleItem sitem : saleItemList){
				Item item = shopService.getItemById(sitem.getItemId());
				sitem.setItem(item);
			}
			sale.setSaleItemList(saleItemList);
		}
		mav.addObject("salelist",salelist);
		mav.addObject("user",user);
		return mav;
	}
	@RequestMapping("user/logout")
	public ModelAndView logout(HttpSession session){
		session.invalidate();
		return loginForm();
	}
	@RequestMapping("user/admin")
	public ModelAndView admin(HttpSession session){
		User loginUser = (User)session.getAttribute("USER");
		if(loginUser == null){
			throw new LoginRequiredException("로그인이 필요합니다.");
			
		}
		if(!loginUser.getUserId().equals("admin")){
			throw new AdminRequiredException("관리자만 가능합니다.");
		}
		
		ModelAndView mav = new ModelAndView();
		List<User> userList = shopService.userList();
		mav.addObject("userList",userList);
		return mav;
	}
	@RequestMapping("user/mailForm")
	public ModelAndView mailForm(String[] idchks){ //idchks를 통해 넘어온 userId들이 문자열 배열에 들어옴
		ModelAndView mav = new ModelAndView();
		
		if(idchks == null || idchks.length == 0){
			throw new MailEmptyException("회원을 선택 하세요.");
		}
		List<User> userList = shopService.userList(idchks);//서비스를 지나 userDaoImpl의 userList가 호출된다. (userDaoImpl.java 참고)
		//userList변수에는 선택된 ID의 정보들을 User객체에 담고있고, 그 User객체들을 List형태로 가지고 있다.
		
		
		mav.addObject("userList",userList); //View단으로 넘겨준다.(mailForm.jsp확인)
		return mav;
	}
	@RequestMapping("user/mail")
	public ModelAndView mail(Mail mail){
		
		ModelAndView mav = new ModelAndView("user/mailsuccess");
		adminMailSend(mail);
		return mav;
	}
	private void adminMailSend(Mail mail) {
		MyAuthenticator auth = new MyAuthenticator(naverid,naverpw);//네이버 메일을 이용하려면 '인증'작업이 필요함.
		Properties prop = new Properties();
		FileInputStream fis;
		try{
			File pr = new File("C:/mywork/spring/workspace/shop-3/mail.properties"); //mail.properties에 메일서버를 이용하는 서버 설정정보가 들어가 있음.
			fis = new FileInputStream(pr);
			prop.load(fis); //내 환경파일 prop로 mail.properties에 있던 내용을 전부 가져오게됨
		}catch(IOException e){
			e.printStackTrace();
		}
		Session session = Session.getInstance(prop,auth); //mail서버와 연결완료 (prop에 있는 메일서버 정보로 네이버 서버에 연결한다. 이때, 인증객체 auth는 반드시 필요하다. (대부분의 메일 서비스들이 보안메일로 바뀌고 나서 인증과정이 필수가됨)
		MimeMessage msg = new MimeMessage(session); //msg : 받는 사람에게 전달할 메일의 내용을 추가할 변수.
		
		try{
			List<InternetAddress> addrs = new ArrayList<InternetAddress>(); //수신자 (받는 이)의 주소설정을 리스트 형태로 함(아직은 비어있음)
			msg.setFrom(new InternetAddress(naverid)); //송신자 (보내는 이)에 대한 주소설정을 함. (InternetAddress에 네이버 아이디를 넣어, 주소를 설정해줌)
			String[] emails = mail.getRecipient().split(",");//현재 받는이들의 주소들이 , 를 기준으로 나뉘어져 있으므로 ,를 기준으로 split()함
			for(int i = 0 ; i<emails.length;i++){
				try{
					addrs.add(new InternetAddress(new String(emails[i].getBytes("euc-kr"),"8859_1"))); //우리는 내부적으로 euc-kr 인코딩을 사용하고 있으므로, 전송시에 8859_1 형태로 바꾸어 줘야 한글이 안깨짐
				}catch(UnsupportedEncodingException e){
					e.printStackTrace();
				}
			}
			InternetAddress[] arr= new InternetAddress[emails.length];//받는이들의 수 만큼 arr 배열을 만듦 -> 이 배열에는 수신자들의 이메일 주소를 가지고 있음
			
			for(int i =0 ; i<addrs.size();i++){
				arr[i] = addrs.get(i);
			}
			msg.setSentDate(new Date()); //보내는 시간을 msg에 설정
			InternetAddress from = new InternetAddress(naverid); 
			msg.setFrom(from);
			msg.setRecipients(Message.RecipientType.TO, arr); //수신자에 대한 설정 (Message.RecipientType.TO : 받는 사람,    Message.RecipientType.CC : 참조인
			msg.setSubject(mail.getTitle());
			msg.setContent(mail.getContents(), mail.getMtype()); //여기까지 msg에 제목, 내용등을 저장한다.
			MimeMultipart multipart = new MimeMultipart(); //여기부턴 첨부파일을 설정하는 부분
			MimeBodyPart message = new MimeBodyPart();
			
			message.setContent(mail.getContents(),mail.getMtype()); 
			multipart.addBodyPart(message);//'내용' 부분을 메일에 추가. (첨부파일은 아직 미포함된 내용. 메일은 기본적으로 바디파트를 나눠서 보내게 됨)
			if(mail.getFile1()!=null && !mail.getFile1().isEmpty()){
				multipart.addBodyPart(bodyPart(mail));//첨부파일을 '내용'에 추가함.
			}
			msg.setContent(multipart); //첨부파일을 추가
			Transport.send(msg); //메일을 전송
		}catch(MessagingException e){
			e.printStackTrace();
		}
	}

	   private BodyPart bodyPart(Mail mail) {
		      MimeBodyPart body = new MimeBodyPart();
		      FileOutputStream fos = null;
		      try{
		         String filename = "c:/shop-3/mail/" + mail.getFile1().getOriginalFilename(); //메일 업로드하는 폴더를 하나 설정.
		         File f1 = new File(filename); //위에 설정한 경로로 파일 객체하나 생성 (아직 비어있음)
		         fos = new FileOutputStream(f1); //업로드된 파일의 내용
		         InputStream in = mail.getFile1().getInputStream();
		         int data;
		         while((data=in.read()) != -1){
		            fos.write(data); //"c:/shop-3/mail/파일이름" 으로 내용이 저장.
		         } //여기까진 단순히 '파일'을 저장하는 과정
		         body.attachFile(f1); // 바디파트에 위 파일을 싣는다.
		         body.setFileName(new String(f1.getName().getBytes("euc-kr"),"8859_1")); //파일의 이름을 "경로/파일이름"말고 실제 파일이름으로 바꿔줌 (f1.getName())
		      }catch(Exception e){
		         e.printStackTrace();
		      }finally{
		         try{
		            if(fos != null){
		               fos.flush();
		               fos.close();
		            }
		         }catch(IOException e){}
		      }
		      return body; //파일이 들어있는 body를 리턴함
		   }

	
	public final class MyAuthenticator extends Authenticator{
		private String id;
		private String pw;
		public MyAuthenticator(String id, String pw){
			this.id=id;
			this.pw=pw;
		}
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(id,pw);
		}
		
	}
	/* birthday받을때, Date타입이어서 타입이 안맞아, 디비에 바로 넣을수가 없다!! -> @InitBinder를 이용한다
	 * 
	 * InitBinder의 역할 - 입력항목 검증(형식을 검증함) + 형 변환기능   => 텍스트창을 통해 birthDay로 들어오는 String값들을 Date값인지 체크하고, Date가 아닌경우 형변환 까지 해준다.
	 * 만약에 형식이 오류 발생하면 ? -> typeMismatch.'파라미터이름' 으로 값이 넘어감 (WebDataBinder 클래스의 registerCustomEditor()메소드가 그 역할을 함)
	 * 
	 */
	@InitBinder //데이터 값들이 넘어올때 @InitBinder어노테이션이 있다면 @RequestMapping보다도 먼저 수행하여, 데이터들을 바인딩시켜 RequestMapping의 User객체로 넘겨주게됨)
	public void initBinder(WebDataBinder binder) throws Exception{
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		
		//Date.class : 파라미터 값을 Date형으로 변경하겠다.
		//"birthDay" : 변경대상이 되는 파라미터의 이름. (birthDay라는 프로퍼티를 Date값으로 변환시키겠다.) => 이 부분 생략시 특정 프로퍼티에 대해서만 변환하는 것이아니라 모든 Date타입의 프로퍼티에 적용한다는 뜻
		//new CustomDateEditor(dfm, true)
		//		- true : 빈문자열을 허용 
		//		- false : 빈문자열을 비허용 (생년월일이 반드시! 필요한경우, false를 적용)
		binder.registerCustomEditor(Date.class,new CustomDateEditor(dfm, true)); //true : 날짜 부분이 비어도 허용하겠다.
	}
}
