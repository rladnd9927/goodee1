package dao;

import java.util.List;

import logic.SemiUser;
import logic.User;
import logic.UserProfile;

public interface SemiUserDao {
	List<SemiUser> getSemiUser();
	List<SemiUser> getSemiUser(String[] idchks);
	SemiUser getSemiUser(String s_email, String s_password);
	SemiUser getSemiUserbyNum(int s_number);
	UserProfile getsemiUserProfile(int s_number);
	void pointUp(int s_number, int s_score);
}
