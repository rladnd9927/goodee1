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

import dao.LikeUserDao;
import dao.ReplyDao;
import dao.SemiUserDao;
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
	@Autowired
	private SemiUserDao semiDao;
	
	
	public List<Sns> getList(int m_number) {//m_number : 게시물객체에 있는 m_number (어떤 회원의 게시물인지 판단하기위함)
		List<Sns> snsList = null;
		
		snsList = snsDao.list(m_number);
		for(int i = 0 ; i<snsList.size(); i++){
			if(snsList.get(i).getM_number() == m_number){
				snsList.get(i).setUserProfile(userDao.getUserProfile(m_number));
			}else{
				break;
			}
		}
		return snsList;
	}

	public List<Integer> getOthersNum(int loginUserNumber) {
		List<Integer> othersNum = null;
		int mNumFromLikeTable = likeUserDao.getMnumFromLikeTable(loginUserNumber);
		if(loginUserNumber!=mNumFromLikeTable){//로그인유저 넘버랑 라이크테이블 m넘버랑 같으면 m넘버를, 틀리면 -1리턴
			othersNum=likeUserDao.othersNumWhenB(loginUserNumber); //나를 좋아요한 회원들의 회원번호를 리스트형태로 가져옴
		}else{
			othersNum = likeUserDao.othersNumWhenA(loginUserNumber);
		}
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
		replyDao.delete(sns_no, m_number, -1); //sns게시물 자체를 삭제할시, -1을 넘겨 플래그로 사용
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

	@Override
	public void replyDelete(int sns_no, int m_number, int r_num) {
		replyDao.delete(sns_no, m_number, r_num);
	}

	@Override
	public void replyReg(int sns_no, int m_number, String r_content) {
		Reply reply = new Reply();
		String m_nickname = semiDao.getUserProfile(m_number).getM_nickname();
		int r_num = replyDao.getMaxRnum(sns_no);
		
		reply.setSns_no(sns_no);
		reply.setM_number(m_number);
		reply.setR_content(r_content);
		reply.setR_reflevel(0);
		reply.setM_nickname(m_nickname);
		reply.setR_num(r_num);
		replyDao.register(reply);
	}
}
