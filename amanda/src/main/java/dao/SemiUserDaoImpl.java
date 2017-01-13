package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import logic.SemiUser;

public class SemiUserDaoImpl implements SemiUserDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "dao.mapper.UserMapper.";

	public List<SemiUser> getSemiUser() {
		return sqlSession.selectList(NS + "getUser" );
	}

}
