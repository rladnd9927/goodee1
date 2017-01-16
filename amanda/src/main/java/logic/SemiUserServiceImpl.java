package logic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SemiUserDao;
import dao.UserDao;

@Service
public class SemiUserServiceImpl implements SemiUserService{

	@Autowired
	private SemiUserDao semiuserDao;
	
	public List<SemiUser> getSemiUser() {
		return semiuserDao.getSemiUser();
	}

	public List<Integer> getOthersNum(int s_number) {
		List<Integer> othersNum = new ArrayList<Integer>();
		return othersNum;
	}

	public SemiUser getSemiUserByIdPw(SemiUser semiuser) {
		return semiuserDao.getSemiUser(semiuser.getS_email(),semiuser.getS_password());
	}

	public UserProfile getsemiUserProfile(int s_number) {
		UserProfile test = semiuserDao.getsemiUserProfile(s_number);
		return test;
	}
	
	@Override
	public void pointUp(int s_number, int s_score) {
		semiuserDao.pointUp(s_number,s_score);
		
	}

	@Override
	public void countUp(int s_number, int s_usercount) {
		semiuserDao.countUp(s_number,s_usercount);
	}
}
