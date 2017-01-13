package logic;

import java.util.List;

public interface SemiUserService {
	List<Integer> getOthersNum(int s_number);
	List<SemiUser> getSemiUser();
	SemiUser getSemiUserByIdPw(SemiUser semiuser);
	UserProfile getsemiUserProfile(int s_number);
}
