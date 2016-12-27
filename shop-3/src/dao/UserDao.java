package dao;

import java.util.List;

import logic.User;

public interface UserDao {

	void create(User user);

	User selectIdPw(String userId, String password);

	User selectId(String id);

	List<User> list();

	List<User> list(String[] idchks);

}
