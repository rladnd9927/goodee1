package dao;

import java.util.List;

import logic.SemiUser;
import logic.User;
import logic.UserProfile;

public interface UserDao {
	void create(SemiUser semiuser);
	void create(UserProfile userprofile);
	List<User> getUser();
	List<User> getUser(String[] idchks);
	User getUser(String id);
	User getUser(String m_email, String m_password);
	
}
