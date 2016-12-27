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
public class BoardController {
	
	@Autowired
	public BoardService boardService;

	@RequestMapping("board/delete")
	public ModelAndView delete(int num, String pass){
		ModelAndView mav = new ModelAndView("board/deleteForm");
		String dbPass=boardService.getPassword(num);
		if(!pass.equals(dbPass)){
			throw new PasswordFailException();
		}
		boardService.delete(num);
		mav.setViewName("redirect:list.shop");
		return mav;
	}
	
	@RequestMapping("board/deleteForm")
	public String deleteForm(){
		return "board/deleteForm";
	}
	
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
	
	@RequestMapping("board/updateForm")
	public ModelAndView updateForm(int num){
		ModelAndView mav = new ModelAndView();
		Board board = boardService.detail(num);
		mav.addObject("board",board);
		
		return mav;
	}
	
	@RequestMapping("board/reply")
	public ModelAndView reply(Board board){
		ModelAndView mav = new ModelAndView();
		boardService.reply(board);
		mav.setViewName("redirect:/board/list.shop");
		return mav;
	}
	
	@RequestMapping("board/replyForm")
	public ModelAndView replyForm(int num){
		ModelAndView mav = new ModelAndView();
		Board board = boardService.detail(num);
		mav.addObject("board",board);
		return mav;
	}
	
	@RequestMapping("board/filedown")
	public void filedown(String filename, HttpServletRequest request ,HttpServletResponse response){//filedown의 경우 view단이 필요가 없으므로, 리턴타입이 필요없다
		

		//톰캣 8.0에서는 인코딩 불가. (현재 톰캣 7.0버전이라 가능한것)
		try {
			filename = new String (filename.getBytes("8859_1"),"euc-kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String filepath = request.getServletContext().getRealPath("/")+"/fileupload/"+filename;
		byte[] buf = new byte[4096];
		FileInputStream fis = null;
		OutputStream out = null;
		
		try{
			fis = new FileInputStream(filepath);
			out = response.getOutputStream();
			
			/*
			 * 파일 다운로드 (파일 유형 상관없이, 한글 인코딩 상관없이)를 하기위해 아래 3가지 과정이 꼭 필요함.
			 */
			
			//1. MIME타입 변경 : 파일 종류 상관없이 모두 다운받도록 함
			response.setContentType("application/octet-stream"); // 내가 받는 모든 파일들을 stream형태로 받아오겠다는 것.
			
			response.setHeader("Content-Disposition", "attachment; filename="+new String(filename.getBytes("euc-kr"),"8859_1"));
			//2. 파일을 첨부하는데, 브라우저가 파일명을 인식할 수 있도록 인코딩 형태를 변경해준다.(euc-kr - > 8859_1로 다시 변경시켜줌)
			
			int readcnt=0;
			
			//3. 파일을 브라우저에 전송해주는 반복문.
			while((readcnt=fis.read(buf))!=-1){
				out.write(buf,0,readcnt);
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
	public ModelAndView detail(int num){
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
		boardService.insert(board,request);
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
	public ModelAndView list(Integer pageNum){
		if(pageNum == null || pageNum.toString().equals("")){
			pageNum=1;
		}
		ModelAndView mav = new ModelAndView();
		
		int limit = 10;
		int listcount = boardService.boardCount();
		List<Board> boardlist = boardService.list(pageNum, limit);
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
		return mav;
	}
	
}
