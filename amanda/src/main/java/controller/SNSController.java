package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.PasswordFailException;
import logic.Board;
import logic.BoardService;


@Controller
public class SNSController {
	
	@Autowired
	public BoardService boardService;
/*
 * deleteForm
 * num 파라미터에 해당하는 게시물을 삭제하기 전에 비밀번호를 입력받는 뷰(deleteForm.jsp)를 출력한다.
 * 
 * delete
 * num, pass 파라미터를 전송받아, 비밀번호가 맞으면 게시물 삭제후 list.shop redirect.
 * 틀리면 PasswordFailException을 발생시킨뒤 비밀번호를 입력받는 뷰(deleteForm.jsp)를 출력
 */
	
	@RequestMapping("sns/snsmain")
	public ModelAndView snsmain(){
		ModelAndView mav = new ModelAndView("redirect:snsmain.jsp");
		return mav;
	}
	
	@RequestMapping("board/delete")
	public ModelAndView delete(int num, String pass){
		ModelAndView mav = new ModelAndView();
		String dbPass = boardService.getPassword(num);
		if(!dbPass.equals(pass)){
			throw new PasswordFailException("비밀번호가 틀립니다.");
		}
		boardService.delete(num);
		mav.setViewName("redirect:list.shop");
		return mav;
	}

	/*
	 * 1.유효성 검증
	 * 2. 파일 업로드, db게시물 수정하기
	 * 3. list.shop으로 재요청하기
	 */
	@RequestMapping("board/update")
	public ModelAndView update(@Valid Board board, BindingResult bindingResult, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("board/updateForm");
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			mav.addObject("board",boardService.detail(board.getNum()));
			return mav;
		}
		String pass = boardService.getPassword(board.getNum());
		if(!pass.equals(board.getPass())){
			mav.setViewName("board/updateForm");
			bindingResult.rejectValue("pass", "error.board.password");
			mav.getModel().putAll(bindingResult.getModel());
			mav.addObject("board",boardService.detail(board.getNum()));
			return mav;
		}
		
		//수정시 새로 업로드 된 파일이 없음
		if(board.getFile1().isEmpty()){
			board.setFileUrl(request.getParameter("file2"));
		}else{//파일 업로드를 다시함
			board.setFileUrl(board.getFile1().getOriginalFilename());
		}
		boardService.update(board,request);
		mav.addObject("board",board);
		mav.setViewName("redirect:list.shop");
		return mav;
	}
	
	
	/*
	 * 1. num 파라미터 전달
	 * 2. num 값에 해당하는 게시물을 db에서 조회
	 * 3. updateForm의 뷰에 전달(updateform.jsp)
	 */
	@RequestMapping("board/updateForm")
	public ModelAndView updateForm(int num){
		ModelAndView mav = new ModelAndView();
		Board board = boardService.detail(num);
		mav.addObject("board",board);
		
		return mav;
	}
	
	@RequestMapping("board/reply")
	public ModelAndView reply(@Valid Board board, BindingResult bindingResult){
		ModelAndView mav = new ModelAndView("board/replyForm");
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		boardService.reply(board);
		mav.setViewName("redirect:/board/list.shop");
		return mav;
	}
	
	@RequestMapping("board/replyForm")
	public ModelAndView replyForm(int num){
		ModelAndView mav = new ModelAndView();
		Board board = boardService.detail(num);
		board.setContent("");
		board.setName("");
		board.setSubject("Re: "+board.getSubject());
		mav.addObject("board",board);
		return mav;
	}
	
	@RequestMapping("board/filedown")
	public void filedown(String filename, HttpServletRequest request ,HttpServletResponse response){//filedown의 경우 view단이 필요가 없으므로, 리턴타입이 필요없다 (void)-> 뷰가 없이 바로 response객체에 데이터를 실어 보내도록 함.
		//현재 업로드되는 모든 파일들은 fileupload라는 폴더에 있는데, 이 경로를 받아오기 위해 request객체를 이용한다 (아래에 리퀘스트 객체를 이용하여 경로를 받아오는 부분이 있음)
		
		String encodeName=null;
		//톰캣 8.0에서는 인코딩 불가. (현재 톰캣 7.0버전이라 가능한것)
		try {
			encodeName = new String (filename.getBytes("8859_1"),"euc-kr"); //filename값을 EUC-KR로 인코딩한 값을 가지고 있음.
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		String filepath = request.getServletContext().getRealPath("/")+"/fileupload/"+encodeName;
		byte[] buf = new byte[4096];
		FileInputStream fis = null;
		OutputStream out = null;
		
		try{
			fis = new FileInputStream(filepath); //filepath를 통해, 다운로드 대상이 되는 파일을 지정한다. -> fis변수에 저장.
			out = response.getOutputStream(); //response객체에 다운파일을 넘겨주기 위함. 
			
			/*
			 * 파일 다운로드 (파일 유형 상관없이, 한글 인코딩 상관없이)를 하기위해 아래 3가지 과정이 꼭 필요함.
			 */
			
			//1. MIME타입 변경 : 파일 종류 상관없이 모두 다운받도록 함
			response.setContentType("application/octet-stream"); // 내가 받는 모든 파일들을 stream형태로 받아오겠다는 것.
			
			response.setHeader("Content-Disposition", "attachment; filename="+filename);//다운받을 파일의 이름을 filename으로 설정
			//2. 파일을 첨부하는데, 브라우저가 파일명을 인식할 수 있도록 인코딩 형태를 변경해준다.(euc-kr - > 8859_1로 다시 변경시켜줌)
			
			int readcnt=0;
			
			//3. 파일을 브라우저에 전송해주는 반복문.
			while((readcnt=fis.read(buf))!=-1){ //fis에 있는 다운로드 대상파일을 4k(buf버퍼 크기)씩 받아다가
				out.write(buf,0,readcnt); //response객체에 실어준다.
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(fis!=null) 
					fis.close();
				if(out!=null){
					out.flush();
					out.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	};
	
	@RequestMapping("board/detail")
	public ModelAndView detail(Integer num){
		boardService.readCntAdd(num);
		Board board = boardService.detail(num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board",board);
		return mav;
	}
	
	@RequestMapping("board/write")
	public ModelAndView write(@Valid Board board, BindingResult bindingResult, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("board/add");
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		boardService.write(board,request);
		mav.setViewName("redirect:/board/list.shop");
		return mav;
	}
	
	
	@RequestMapping("board/add")
	public ModelAndView add(){
		ModelAndView mav = new ModelAndView();
		mav.addObject(new Board());
		mav.setViewName("board/add");
		return mav;
	}
	
	@RequestMapping("board/list")
	public ModelAndView list(Integer pageNum, String column, String find, HttpServletRequest request){
		if(pageNum == null || pageNum.toString().equals("")){
			pageNum=1;
		}
		if(column == null||column.equals(""))
			column=null;
		if(find == null||find.equals(""))
			find=null;
		if(column == null)
			find=null;
		if(find==null)
			column=null;
		if(find!=null && request.getMethod().equalsIgnoreCase("GET")){
			try{
				find=new String(find.getBytes("8859_1"),"euc-kr");
			}catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
		}
			
		
		ModelAndView mav = new ModelAndView();
		
		int limit = 10;
		int listcount = boardService.boardCount(column, find);
		List<Board> boardlist = boardService.list(pageNum, limit,column,find);
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = (((int)(pageNum/10.0 + 0.9))-1)*10+1;
		int endpage = startpage +9;
		if(endpage>maxpage) endpage = maxpage;
		int boardnum=listcount - ((pageNum-1)*limit);//해당 페이지 마다 시작 번호를 찾아 넘겨줌
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdate.format(new Date());
		mav.addObject("today", today);
		mav.addObject("pageNum",pageNum);
		mav.addObject("maxpage",maxpage);
		mav.addObject("startpage",startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount", listcount);
		mav.addObject("boardlist", boardlist);
		mav.addObject("boardnum",boardnum);
		mav.addObject("find",find);
		return mav;
	}
	
}
