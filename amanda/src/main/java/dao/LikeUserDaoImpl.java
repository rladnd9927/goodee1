package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeUserDaoImpl implements LikeUserDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "dao.mapper.LikeUserMapper.";
	
	public List<Integer> othersNum(int m_number) {
		Map<String, Object> param= new HashMap<String, Object>();
		param.put("m_number", m_number);
		return sqlSession.selectList(NS+"othersNum",param);
	}
  
}
