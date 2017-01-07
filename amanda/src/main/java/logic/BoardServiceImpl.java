package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao dao;
	
	//@Override
	public int boardCount(String column, String find) {
		return dao.countAll(column,find);
	}

	//@Override
	public List<Board> list(Integer pageNum, int limit, String column, String find) {
		return dao.list(pageNum,limit,column,find);
	}

	//@Override
	public void readCntAdd(Integer num) {
		dao.readCntAdd(num);
	}

	//@Override
	public Board detail(Integer num) {
		return dao.detail(num);
	}

	//@Override
	public void write(Board board, HttpServletRequest request) {
		if(board.getFile1() != null && !board.getFile1().isEmpty()){
			updateFileCreate(board.getFile1(),request);
			board.setFileUrl(board.getFile1().getOriginalFilename());
		}
		int num = dao.getMaxNum();
		board.setNum(++num);
		board.setRef(num);
		board.setRefLevel(0);
		board.setRefStep(0);
		dao.insert(board);
	}

	
	/*
	 * 스프링에서 제공하는 multipartFile이라는 객체(실체는 없지만, 메모리 공간에 할당받아 어떤 형태의 파일이든 그 메모리에 넣어둠)에다가, 아웃풋스트림을 통해 거기에 집어넣어두고,
	 * 인풋스트림을 통해서 멀티파트에 있는 것을 가져와 사용한다.
	 */
	private void updateFileCreate(MultipartFile file1, HttpServletRequest request) {
		String uploadPath = request.getServletContext().getRealPath("/")+"/fileupload/";
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(uploadPath + file1.getOriginalFilename());
			InputStream in = file1.getInputStream();
			int len;
			byte[] buf = new byte[4096];
			while((len=in.read(buf))!=-1){
				fos.write(buf,0,len);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(fos!=null){
					fos.flush();
					fos.close();
				}
			}catch(IOException e){
				
			}
		}
	}

	//@Override
	public void reply(Board board) {
		/*
		 * 입력내용을 db에 insert하기
		 * -refStep +1로 변경
		 * -refLevel++, refStep++하여 insert하기 (최대 num+1 생성)
		 * 
		 */
		int num = dao.getMaxNum();
		dao.refStepAdd(board); 
		board.setNum(++num);
		board.setRefLevel(board.getRefLevel()+1);
		board.setRefStep(board.getRefStep()+1);
		board.setFileUrl("");
		dao.insert(board);
	}

	//@Override
	public String getPassword(int num) {
		return dao.selectOne(num).getPass();
	}

	//@Override
	public void update(Board board, HttpServletRequest request) {
		if(!board.getFile1().isEmpty()){
			updateFileCreate(board.getFile1(),request);
		}
		dao.update(board);
	}

	//@Override
	public void delete(int num) {
		dao.delete(num);
	}
}
