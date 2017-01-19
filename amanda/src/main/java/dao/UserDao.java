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
	UserProfile getUserProfile(int m_number);
	List<User> userlist();
	   List<User> likelist(int userNum, User myNum,  int c_number);
	   String ser(int userNum, User myNum);
	   String aer(int userNum, User myNum);
	   List<User> likelist2(int userNum, User myNum);
	   List<User> likelist3(int userNum, User myNum, int m_like);
	   List<User> nolist(int userNum, User myNum);
	   List<User> list(String column, String find);
	   
	   int m_like(int userNum, User myNum);
	   
       String cer(int userNum, User myNum);
}
