package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import dao.LikeUserDao;
import dao.ReplyDao;
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
	@Autowired
	private ReplyDao replyDao;
	
	public List<Sns> getList(int m_number) {
		List<Sns> snsList = snsDao.list(m_number);
		
		return snsList;
	}

	public List<Integer> getOthersNum(int m_number) {
		List<Integer> othersNum = likeUserDao.othersNum(m_number); //나를 좋아요한 회원들의 회원번호를 리스트형태로 가져옴
		return othersNum;
	}

	public void write(Sns sns, HttpServletRequest request) {
		if(sns.getSns_picture() != null && !sns.getSns_picture().isEmpty()){
			updateFileCreate(sns.getSns_picture(),request);
			sns.setFileUrl(sns.getSns_picture().getOriginalFilename());
		}else{
			sns.setFileUrl("nothing");
		}
		int snsMaxNum = snsDao.getMax(sns.getM_number());//로그인 회원의 M_number에 해당하는 SNS목록들중, 최대 SNS_no를 불러옴
		sns.setSns_no(++snsMaxNum); 
		snsDao.insert(sns);
	}

	private void updateFileCreate(MultipartFile sns_picture, HttpServletRequest request) {
		String uploadPath = request.getServletContext().getRealPath("/")+"/fileupload/";
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(uploadPath + sns_picture.getOriginalFilename());
			InputStream in = sns_picture.getInputStream();
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
		if(!sns.getSns_picture().isEmpty()){
			updateFileCreate(sns.getSns_picture(),request);
		}
		snsDao.update(sns);
	}
	public User getUserbyNum(int m_number) {
		User snsUser = userDao.getUserbyNum(m_number);
		return snsUser;
	}

	public void delete(int sns_no, int m_number) {
		snsDao.delete(sns_no,m_number);
	}

	public Sns detail(Integer sns_no, int m_number) {
		return snsDao.detail(sns_no,m_number);
	}

	public List<Reply> replyList(int sns_no, int m_number) {
		return replyDao.replyList(sns_no,m_number);
	}

	@Override
	public String ObjectToJSONString(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(obj);
		return json;
	}
}
