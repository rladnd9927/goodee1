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
	@Override
	public List<Integer> getOthersNum(int m_number) { //m_number는 현재 로그인 유저의 회원번호
		List<Integer> othersNum = new ArrayList<Integer>();
		return othersNum;
	}
	public void createUser(UserProfile userprofile, HttpServletRequest request) {
		if(userprofile.getM_picture1() != null && !userprofile.getM_picture1().isEmpty()) {
			uploadFileCreate1(userprofile.getM_picture1(),request);
		}
		if(userprofile.getM_picture2() != null && !userprofile.getM_picture2().isEmpty()) {
			uploadFileCreate2(userprofile.getM_picture1(),request);
		}
		if(userprofile.getM_picture3() != null && !userprofile.getM_picture3().isEmpty()) {
			uploadFileCreate3(userprofile.getM_picture3(),request);
		}
		userDao.createSemi(userprofile);
		userDao.createProfile(userprofile);
	}
	
	private void uploadFileCreate1(MultipartFile m_picture1, HttpServletRequest request) {
		String uploadPath = request.getServletContext().getRealPath("/") + "/fileupload/";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(uploadPath + m_picture1.getOriginalFilename());
			InputStream in = m_picture1.getInputStream();
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
	private void uploadFileCreate2(MultipartFile m_picture2, HttpServletRequest request) {
		String uploadPath = request.getServletContext().getRealPath("/") + "/fileupload/";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(uploadPath + m_picture2.getOriginalFilename());
			InputStream in = m_picture2.getInputStream();
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
	private void uploadFileCreate3(MultipartFile m_picture3, HttpServletRequest request) {
		String uploadPath = request.getServletContext().getRealPath("/") + "/fileupload/";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(uploadPath + m_picture3.getOriginalFilename());
			InputStream in = m_picture3.getInputStream();
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

	public List<User> userlist() {
		return userDao.userlist();
	}

	   public List<User> likelist(String userId, User User, int c_number) {
	      return userDao.likelist(userId,User,c_number);
	   }


	   public List<Member> mypage(User User) {
	      return MemberDao.mypage(User); 
	   }

	   public List<Member> youpage(User User) {
	      return MemberDao.youpage(User);
	   }
	   

	   public List<User> likelist2(String userId, User User) {
	      return userDao.likelist2(userId,User);
	   }

	   public String ser(String userId, User User) {
	      System.out.println(User+"ser로 여기까진옴"); 
	      return userDao.ser(userId, User);
	   }

	   public String aer(String userId, User User) {
	      System.out.println(User+"aer로 여기까진옴"); 
	      return userDao.aer(userId, User);
	   }
		@Override
	   public List<User> likelist(String userId, User User) {
	      return userDao.likelist(userId,User);
	   }
		@Override
	   public List<User> nolist(String userId, User User) {
	      return userDao.nolist(userId,User);

	   }

}
