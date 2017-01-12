package logic;

import java.util.ArrayList;
import java.util.List;

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
}
