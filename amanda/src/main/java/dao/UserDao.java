package dao;

import java.util.List;

import logic.User;

public interface UserDao {
	User getUser(String userId, String password);
	void create(User user);
	List<User> getUser();
	List<User> getUser(String[] idchks);
}
