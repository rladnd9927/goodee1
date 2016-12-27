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
	@Override
	public int boardCount() {
		return dao.countAll();
	}

	@Override
	public List<Board> list(Integer pageNum, int limit) {
		return dao.list(pageNum,limit);
	}

	@Override
	public void insert(Board board, HttpServletRequest request) {
		board.setFileUrl(board.getFile1().getOriginalFilename());
		
		if(board.getFile1() != null && !board.getFile1().isEmpty()){
			uploadFileCreate(board.getFile1(),request);
		}
		int num = dao.getMaxNum();
		board.setNum(++num);
		board.setRef(num);
		board.setRefLevel(0);
		board.setRefStep(0);
		dao.insert(board);
	}

	private void uploadFileCreate(MultipartFile file1, HttpServletRequest request) {
		String uploadPath = request.getServletContext().getRealPath("/")+"/fileupload/";
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(uploadPath + file1.getOriginalFilename());
			InputStream in = file1.getInputStream();
			int len;
			byte[] buf = new byte[1024];
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

	@Override
	public void readCntAdd(int num) {
		dao.readCntAdd(num);
	}

	@Override
	public Board detail(int num) {
		return dao.selectOne(num);
	}

	@Override
	public void reply(Board board) {
		/*
		 * 1. 게시물 번호 board테이블의 num의 최대값을 구하기
		 * 2. refStep을 변경 목록 출력시 순서 설정
		 * 3. board테이블에 insert하기
		 */
		
		int num = dao.getMaxNum();// 1
		dao.refStepAdd(board); //2
		
		board.setNum(++num);
		board.setRefLevel(board.getRefLevel()+1);
		board.setRefStep(board.getRefStep()+1);
		board.setFileUrl("");
		dao.insert(board);//3
		
	}

	@Override
	public String getPassword(int num) {
		return dao.selectOne(num).getPass();
	}

	@Override
	public void update(Board board, HttpServletRequest request) {
		if(!board.getFile1().isEmpty()){
			uploadFileCreate(board.getFile1(),request);
		}
		dao.update(board);
	}

	@Override
	public void delete(int num) {
		dao.delete(num);
	}
	

}
