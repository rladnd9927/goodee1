package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.SemiUserDao;
import dao.UserDao;

public class SemiUserServiceImpl implements SemiUserService{

	@Autowired
	private SemiUserDao semiuserDao;
	
	public List<SemiUser> getSemiUser() {
		return semiuserDao.getSemiUser();
	}
}
