package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dao.LikeUserDao;
import dao.SnsDao;
import dao.UserDao;

@Service
public class SnsServiceImpl implements SnsService {

	@Autowired
	private SnsDao snsDao;
	@Autowired
	private LikeUserDao	likeUserDao;
	@Autowired
	private UserDao userDao;
	
	public List<Sns> getList(int m_number) {
		List<Sns> snsList = snsDao.list(m_number);
		
		return snsList;
	}

	public List<Integer> getOthersNum(int m_number) {
		List<Integer> othersNum = likeUserDao.othersNum(m_number); //나를 좋아요한 회원들의 회원번호를 리스트형태로 가져옴
		return othersNum;
	}

	public Sns detail(Integer sns_no) {
		Sns snsdetail = snsDao.detail(sns_no);
		return snsdetail;
	}

	public List<Reply> replyList(Integer sns_no) {
		List<Reply> replyList = snsDao.reply(sns_no);
		return replyList;
	}

	public void write(Sns sns, HttpServletRequest request) {
		if(sns.getSns_file() != null && !sns.getSns_file().isEmpty()){
			updateFileCreate(sns.getSns_file(),request);
			sns.setFileUrl(sns.getSns_file().getOriginalFilename());
		}
		snsDao.insert(sns);
	}

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
	public void update(Sns sns, HttpServletRequest request) {
		if(!sns.getSns_file().isEmpty()){
			updateFileCreate(sns.getSns_file(),request);
		}
		snsDao.update(sns);
	}
	public User getUserbyNum(int m_number) {
		User snsUser = userDao.getUserbyNum(m_number);
		return snsUser;
	}

	public void delete(int sns_no) {
		snsDao.delete(sns_no);
	}
}
