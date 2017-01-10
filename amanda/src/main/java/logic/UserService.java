package logic;

import java.util.List;

public interface UserService {
	List<Integer> getOthersNum(int m_number);
	void createUser1(SemiUser semiuser);
	void createUser2(UserProfile userprofile);
}
