package dao;

import java.util.List;

import logic.SemiUser;
import logic.User;
import logic.UserProfile;

public interface UserDao {
	List<User> getUser();
	List<User> getUser(String[] idchks);
	User getUser(String id);
	User getUser(String m_email, String m_password);
	User getUserbyNum(int m_number);
	void createSemi(UserProfile userprofile);
	void createProfile(UserProfile userprofile);
}
