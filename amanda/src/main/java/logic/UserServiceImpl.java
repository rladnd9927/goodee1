package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/*import dao.SnsDao;*/
import dao.UserDao;
import dao.MemberDao;
//import dao.SnsDao;
@Service
public class UserServiceImpl implements UserService{ 
	@Autowired
	private UserDao userDao;

	@Autowired
	private MemberDao MemberDao;
	
	/*@Autowired
	private SnsDao snsDao;*/

	/*@Autowired
	public SnsDao snsDao;*/

	public List<Integer> getOthersNum(int m_number) { //m_number는 현재 로그인 유저의 회원번호
		List<Integer> othersNum = new ArrayList<Integer>();
		return othersNum;
	}

	public void createUser(UserProfile userprofile, HttpServletRequest request) {
		if(userprofile.getM_picture1() != null && !userprofile.getM_picture1().isEmpty()) {
			uploadFileCreate(userprofile.getM_picture1(),request);
		}
		if(userprofile.getM_picture2() != null && !userprofile.getM_picture2().isEmpty()) {
			uploadFileCreate(userprofile.getM_picture2(),request);
		}
		if(userprofile.getM_picture3() != null && !userprofile.getM_picture3().isEmpty()) {
			uploadFileCreate(userprofile.getM_picture3(),request);
		}
		userprofile.setM_pictureUrl1(userprofile.getM_picture1().getOriginalFilename());
		userprofile.setM_pictureUrl2(userprofile.getM_picture2().getOriginalFilename());
		userprofile.setM_pictureUrl3(userprofile.getM_picture3().getOriginalFilename());
		userDao.createSemi(userprofile);
		userDao.createProfile(userprofile);
	}

	private void uploadFileCreate(MultipartFile m_picture, HttpServletRequest request) {
		String uploadPath = request.getServletContext().getRealPath("/") + "/fileupload/";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(uploadPath + m_picture.getOriginalFilename());
			InputStream in = m_picture.getInputStream();
			int len;
			byte[] buf = new byte[4096];
			while((len = in.read(buf)) != -1) {
				fos.write(buf,0,len);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.flush(); fos.close();
				}
			} catch(IOException e) {}
		}
	}
	
	public User getUserByIdPw(User user) {
		return userDao.getUser(user.getM_email(),user.getM_password());
	}

	public List<User> getUser() {
		return userDao.getUser();
	}

	public UserProfile getUserProfile(int m_number) {
		return userDao.getUserProfile(m_number);
	}

	public int getNum() {
		return userDao.getNum();
	}

	public void delete(int num) {
		userDao.delete(num);
	}


	public List<User> userlist() {
		return userDao.userlist();
	}
	





	public List<Member> mypage(User myNum) {
	   return MemberDao.mypage(myNum); 
	}
	
	public List<Member> youpage(User myNum) {
	   return MemberDao.youpage(myNum);
	}
	
	public String ser(int userNum, User myNum) {
	   return userDao.ser(userNum, myNum);
	}
	
	public String aer(int userNum, User myNum) {
	   return userDao.aer(userNum, myNum);
	}
	@Override
	  public List<User> likelist(int userNum, User myNum) {
	     return userDao.likelist(userNum,myNum);
	  }
	
	public List<User> likelist(int userNum, User myNum, int c_number) {
		return userDao.likelist(userNum,myNum,c_number);
	}
	
	public List<User> likelist2(int userNum, User myNum) {
		return userDao.likelist2(userNum,myNum);
	}
	
	@Override
	  public List<User> nolist(int userNum, User myNum) { 
	     return userDao.nolist(userNum,myNum); 
	
	  }
	@Override
	public List<User> listFind(String column, String find) {
		return userDao.list(column, find);
	}

}
