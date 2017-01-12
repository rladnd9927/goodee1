package dao;

import java.util.List;

import logic.SemiUser;
import logic.User;

public interface SemiUserDao {
	List<SemiUser> getSemiUser();
	List<SemiUser> getSemiUser(String[] idchks);
	SemiUser getSemiUser(String s_email, String s_password);
	SemiUser getSemiUserbyNum(int s_number);
}
