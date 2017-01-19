package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
	
	
	public List<Sns> getList(int m_number) {//m_number : �Խù���ü�� �ִ� m_number (� ȸ���� �Խù����� �Ǵ��ϱ�����)
		List<Sns> snsList = null;
		String encodeFilename = null;
		snsList = snsDao.list(m_number);
		for(int i = 0 ; i<snsList.size(); i++){
			try {
				encodeFilename = new String(snsList.get(i).getFileUrl().getBytes("8859_1"),"euc-kr");
				snsList.get(i).setFileUrl(encodeFilename);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			if(snsList.get(i).getM_number() == m_number){
				snsList.get(i).setUserProfile(userDao.getUserProfile(m_number));
			}else{
				break;
			}
		}
		return snsList;
	}

	public List<Integer> getOthersNum(Integer loginUserNumber) {
		List<Integer> othersNum = null;
		List<Integer> result = new ArrayList<Integer>();
		List<LikeUser> likeUserList = null;
		likeUserList = likeUserDao.getAll(loginUserNumber); //�α����� ������ ��ȣ�� �ش��ϴ� C_number�� ���� ������ ( m_number�̵� y_number�̵� �α��� ������ ��ȣ�� �ִ� ��� �÷��� �ܾ��)
		
		/*1. m��, y�ѿ� �α��� ������ �ѹ��� ���� ��� ����� �����´�.

		2. �ݺ����� ���鼭, �Ʒ��� ��츦 üũ�ϰ� ��쿡 ���� �ٸ� ��� ����(���������� �̾ƾ��ϴ°� �޶��� m���̳� Y���̳�)
		�� ��ȣ�� M�ѹ��̰� M����ũ�� 0
		 - > ���� ���ƿ並 ���� ����
		 == ����ȣ�� Y_number

		�� ��ȣ�� M�ѹ��̰� M����ũ�� 1
		- > ���� ���ƿ� (���� ���� ���ƿ� ��)
		== ��� ��ȣ�� Y_NUMBER

		�� ��ȣ�� Y�ѹ��̰� M����ũ�� 1
		-> ���� ���ƿ� (��밡 �� ���� ���ƿ� ��)*/
		int flagA = 0; //for�� break �÷���
		int flagB = 0; //for�� break �÷���
		int flagC = 0; //for�� break �÷���
		for(int i = 0 ; i < likeUserList.size(); i++){ //�Ʒ� ������ ��츸 SNS����Ʈ�� ����ִ� ��쿡 �ش�. -> ������ ��쿡 �´� ����� �ѹ� (��쿡����, m���ϼ���, y���� ���� ����.) 
			if(likeUserList.get(i).getM_like() !=1 && likeUserList.get(i).getM_number() == loginUserNumber && flagA==0){
				othersNum=likeUserDao.othersNumWhenA(loginUserNumber); //���� ���ƿ��� ȸ������ ȸ����ȣ�� ����Ʈ���·� ������
				
				for(int j = 0; j<othersNum.size();j++){
					result.add(othersNum.get(j));
				}
				flagA++;
				continue;
			}else if(likeUserList.get(i).getM_like() == 1 && likeUserList.get(i).getM_number() == loginUserNumber && flagB==0){
				othersNum=likeUserDao.othersNumWhenB(loginUserNumber);
				for(int j = 0; j<othersNum.size();j++){
					result.add(othersNum.get(j));
				}
				flagB++;
				continue;
			}else if(likeUserList.get(i).getM_like() ==1 && likeUserList.get(i).getY_number() == loginUserNumber && flagC==0){
				othersNum=likeUserDao.othersNumWhenC(loginUserNumber);
				for(int j = 0; j<othersNum.size();j++){
					result.add(othersNum.get(j));
				}
				flagC++;
				continue;
			}
		}
		return result;
	}

	public void write(Sns sns, HttpServletRequest request) {
		if(sns.getSns_picture() != null && !sns.getSns_picture().isEmpty()){
			updateFileCreate(sns.getSns_picture(),request);
			sns.setFileUrl(sns.getSns_picture().getOriginalFilename());
		}else{
			sns.setFileUrl("nothing");
		}
		int snsMaxNum = snsDao.getMax(sns.getM_number());//�α��� ȸ���� M_number�� �ش��ϴ� SNS��ϵ���, �ִ� SNS_no�� �ҷ���
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
		replyDao.delete(sns_no, m_number, -1); //sns�Խù� ��ü�� �����ҽ�, -1�� �Ѱ� �÷��׷� ���
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
		reply.setM_nickname(m_nickname);
		reply.setR_num(++r_num);
		replyDao.register(reply);
	}
}
