package dao;

import java.util.List;

import logic.SemiUser;
import logic.User;
import logic.UserProfile;

public interface UserDao {
	List<User> getUser();
	List<User> getUser(String[] idchks);
	User getUser(String m_email, String m_password);
	User getUserbyNum(int m_number);
	void createSemi(UserProfile userprofile);
	void createProfile(UserProfile userprofile);
	UserProfile getUserProfile(int m_number);
	List<User> userlist();
	   List<User> likelist(String userId, User User,  int c_number);

	   String ser(String userId, User User);

	   List<User> likelist2(String userId, User User);

	   String aer(String userId, User User);

	   List<User> likelist(String userId, User User);

	   List<User> nolist(String userId, User User);
}
