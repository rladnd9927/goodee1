package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.UserMapper;
import logic.SemiUser;
import logic.User;
import logic.UserProfile;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "dao.mapper.UserMapper.";

	//@Override
	public User getUser(String email, String password) {
		Map<String, String> param = new HashMap<String,String>();
		param.put("email", email);
		param.put("password", password);
		return sqlSession.selectOne(NS + "getUser",param);
	}

/*	//@Override
	public void create(User user) {
		sqlSession.getMapper(UserMapper.class).create(user);
	}*/

	//@Override
	public List<User> getUser() {
		return sqlSession.selectList(NS + "getUser" );
	}

	//@Override
	public List<User> getUser(String[] idchks) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idchks", idchks);
		return sqlSession.selectList(NS+"getUser",map);
	}

	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserbyNum(int m_number) {
		return sqlSession.getMapper(UserMapper.class).getUserbyNum(m_number);
	}

	public void createSemi(UserProfile userprofile) {
		sqlSession.getMapper(UserMapper.class).createsemi(userprofile);
	}

	public void createProfile(UserProfile userprofile) {
		sqlSession.getMapper(UserMapper.class).createprofile(userprofile);
	}
}
