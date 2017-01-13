package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.SemiUserMapper;
import dao.mapper.UserMapper;
import logic.SemiUser;
import logic.UserProfile;

@Repository
public class SemiUserDaoImpl implements SemiUserDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "dao.mapper.SemiUserMapper.";

	//@Override
	public List<SemiUser> getSemiUser() {
		return sqlSession.getMapper(SemiUserMapper.class).getSemiUser();
	}

	public List<SemiUser> getSemiUser(String[] idchks) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idchks", idchks);
		return sqlSession.selectList(NS+"getSemiUser",map);
	}

	public SemiUser getSemiUser(String email, String password) {
		Map<String, String> param = new HashMap<String,String>();
		param.put("email", email);
		param.put("password", password);
		return sqlSession.selectOne(NS + "getSemiUser",param);
	}

	public SemiUser getSemiUserbyNum(int s_number) {
		return sqlSession.getMapper(SemiUserMapper.class).getSemiUserbyNum(s_number);
	}

	public UserProfile getsemiUserProfile(int s_number) {
		return sqlSession.getMapper(SemiUserMapper.class).getsemiUserProfile(s_number);
	}

}
