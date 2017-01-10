package logic;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*import dao.SnsDao;*/
import dao.UserDao;
//import dao.SnsDao;
@Service
public class UserServiceImpl implements UserService{ 
	@Autowired
	private UserDao userDao;
	
	/*@Autowired
	private SnsDao snsDao;*/

	/*@Autowired
	public SnsDao snsDao;*/

	public List<Integer> getOthersNum(int m_number) { //m_number는 현재 로그인 유저의 회원번호
		List<Integer> othersNum = new ArrayList<Integer>();
		return othersNum;
	}

	public void createUser1(SemiUser semiuser) {
		userDao.create(semiuser);
	}

	public void createUser2(UserProfile userprofile) {
		userDao.create(userprofile);
	}

}
