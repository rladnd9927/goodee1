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
	private BoardService boardService;
	
	@RequestMapping("board/list")
	public ModelAndView list(Integer pageNum, String column, String find, HttpServletRequest request){
		if(pageNum == null || pageNum.toString().equals("")){
			pageNum = 1;
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
		int limit = 10;
		int listcount = boardService.boardCount(column,find);
		List<Board> boardlist = boardService.list(pageNum,limit,column,find);
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage=(((int)(pageNum/10.0 + 0.9)) -1) *10 +1;
		int endpage = startpage + limit -1;
		if(endpage > maxpage) endpage = maxpage;
		int boardnum = listcount - ((pageNum - 1) * limit);
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdate.format(new Date());
		mav.addObject("today",today);
		mav.addObject("pageNum",pageNum);
		mav.addObject("maxpage",maxpage);
		mav.addObject("startpage",startpage);
		mav.addObject("endpage",endpage);
		mav.addObject("listcount",listcount);
		mav.addObject("boardlist",boardlist);
		mav.addObject("boardnum",boardnum);
		mav.addObject("find",find);
		return mav;
	}
	
	@RequestMapping("board/detail")
	public ModelAndView detail(Integer num){
		boardService.readCntAdd(num);
		Board board = boardService.detail(num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board",board);
		return mav;
	}
	
	@RequestMapping("board/add")
	public ModelAndView add(){
		ModelAndView mav = new ModelAndView();
		mav.addObject(new Board());
		mav.setViewName("board/add");
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
		mav.setViewName("redirect:list.shop");
		return mav;
	}
	
	@RequestMapping("board/filedown")
	public void filedown(String filename, HttpServletRequest request, HttpServletResponse response){
		String encodeName = null;
		try {
			//encodeName: filname값을 euc-kr로 인코딩한 값을 저장
			encodeName = new String(filename.getBytes("8859_1"),"euc-kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String filepath = request.getServletContext().getRealPath("/") + "/fileupload/" + encodeName;
		byte[] buf = new byte[4096];
		FileInputStream fis = null;
		OutputStream out = null;
		try{
			fis = new FileInputStream(filepath);
			//fis: 다운로드 대상이되는 파일 지정
			out = response.getOutputStream();
			
			response.setContentType("application/actet-stream");
			//브라우저에게 다운로드 대상임을 지정
			response.setHeader("Content-Disposition", "attachment; filename=" + filename);
			//다운로드파일의 이름 설정
			
			int readcnt = 0;
			while((readcnt = fis.read(buf)) != -1){
				out.write(buf,0,readcnt);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(fis != null) fis.close();
				if(out != null){
					out.flush(); out.close();
				}
			}catch(IOException e) {}
		}
	}
	//num파라미터에 해당하는 게시물을읽어서 뷰로 전달하기
	//board/replyForm.jsp
	@RequestMapping("board/replyForm")
	public ModelAndView replyForm(int num){
		ModelAndView mav = new ModelAndView();
		Board board = boardService.detail(num);
		board.setContent("");
		board.setName("");
		board.setSubject("Re:" + board.getSubject());
		mav.addObject("board",board);
		return mav;
	}
	
	//답글등록하기
	//1. 유효성 검증(제목, 작성자, 내용)
	//2. 입력내용을 db에 insert하기
	//		└ refStep + 1하기
	//		└ refLevel++, refStep++하여 insert하기(최대 num + 1 로 생성)
	//3. list.shop을 재요청하기
	@RequestMapping("board/reply")
	public ModelAndView reply(@Valid Board board, BindingResult bindingResult){
		ModelAndView mav = new ModelAndView("board/replyForm");
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		boardService.reply(board);		
		mav.setViewName("redirect:list.shop");
		return mav;		
	}
	/*
	 * num 파라미터 전달
	 * num값의 게시물을 db에서 조회
	 * 뷰(board/updateForm.jsp)에 전달
	 */
	@RequestMapping("board/updateForm")
	public ModelAndView updateForm(int num){
		ModelAndView mav = new ModelAndView();
		Board board = boardService.detail(num);
		mav.addObject("board",board);
		return mav;
	}
	
	/*
	 * 1.유효성 검증
	 * 2.파일업로드 + db게시물 수정하기
	 * 3.list.jsp재요청
	 */
	@RequestMapping("board/update")
	public ModelAndView update(@Valid Board board, BindingResult bindingResult,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("board/updateForm");
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			mav.addObject("board",boardService.detail(board.getNum()));
			return mav;
		}
		String pass = boardService.getPassword(board.getNum());
		if(!pass.equals(board.getPass())){
			mav.setViewName("board/updateForm");
			bindingResult.rejectValue("pass", "error.baord.password");
			mav.getModel().putAll(bindingResult.getModel());
			mav.addObject("board",boardService.detail(board.getNum()));
			return mav;
		}
	    if(board.getFile1().isEmpty()){
		    board.setFileUrl(request.getParameter("file2"));
	    }else{
		    board.setFileUrl(board.getFile1().getOriginalFilename());
	    }
	    boardService.update(board,request);
	    mav.addObject("board",board);
	    mav.setViewName("redirect:list.shop");
	    return mav;	
	}
	
	/*
	 * num파라미터에 해당하는 글을 삭제 전 비밀번호를 입력받는 뷰(board/deleteForm.jsp)를 출력
	 */
	@RequestMapping("board/deleteForm")
	public ModelAndView deleteForm(int num){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/deleteForm");
		return mav;
	}
	
	/*
	 * num,pass 파라미터를 전송받아서 비밀번호가 맞는 경우 게시물을 삭제
	 * 틀리면 PasswordFailException를 발생
	 * 맞으면 list.shop 재요청하기
	 */
	@RequestMapping("board/delete")
	public ModelAndView delete(int num, String pass){
		ModelAndView mav = new ModelAndView("board/deleteForm");
	    String dbPass = boardService.getPassword(num);
	    if(!pass.equals(dbPass)){
		    throw new PasswordFailException();
	    }
	    boardService.delete(num);
	    mav.setViewName("redirect:list.shop");
	    return mav;
	}
}
