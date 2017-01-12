package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	List<Integer> getOthersNum(int m_number);
	User getUserByIdPw(User user);
	void createUser(UserProfile userprofile, HttpServletRequest request);
	List<User> getUser();
	UserProfile getUserProfile();
}
