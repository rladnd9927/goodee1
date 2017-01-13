package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	List<Integer> getOthersNum(int m_number);
	User getUserByIdPw(User user);
	void createUser(UserProfile userprofile, HttpServletRequest request);
	List<User> getUser();
	UserProfile getUserProfile(int m_number);
	List<User> userlist();
   List<Member> mypage(User chatUser);
   List<Member> youpage(User chatUser);
   String ser(String userId, User chatUser);
   String aer(String userId, User chatUser);
   List<User> likelist(String userId, User chatUser);
   List<User> likelist(String userId, User chatUser, int c_number);
   List<User> likelist2(String userId, User chatUser);
   List<User> nolist(String userId, User chatUser);
}
