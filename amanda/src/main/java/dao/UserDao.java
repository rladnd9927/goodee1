package dao;

import java.util.List;

import logic.SemiUser;
import logic.User;
import logic.UserProfile;

public interface UserDao {
	User getUser(String userId, String password);
	void create(SemiUser semiuser);
	void create(UserProfile userprofile);
	List<User> getUser();
	List<User> getUser(String[] idchks);
	
}
