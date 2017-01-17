package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	List<Integer> getOthersNum(int m_number);
	User getUserByIdPw(User user);
	void createUser(UserProfile userprofile, HttpServletRequest request);
	int getNum();
	List<User> getUser();
	void delete(int num);
	UserProfile getUserProfile(int m_number);
	List<User> userlist();
	List<Member> mypage(User myNum);
	List<Member> youpage(User myNum);
	String ser(int userNum, User myNum);
	String aer(int userNum, User myNum);
	List<User> likelist(int userNum, User myNum);
	List<User> likelist(int userNum, User myNum, int c_number);
	List<User> likelist2(int userNum, User myNum);
	List<User> nolist(int userNum, User myNum);
	
}
