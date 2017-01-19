package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.LikeUserMapper;
import logic.LikeUser;

@Repository
public class LikeUserDaoImpl implements LikeUserDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "dao.mapper.LikeUserMapper.";
	
	public List<Integer> othersNumWhenA(int m_number) { //���ƿ並 ���� ���� ����� �α��� �ҽ�,
		Map<String, Object> param= new HashMap<String, Object>();
		param.put("m_number", m_number);
		return sqlSession.selectList(NS+"othersNumA",param);
	}
	public List<Integer> othersNumWhenB(int m_number) { // ���ƿ並 �ι�°�� ���� ����� �α��� �� ��,
		Map<String, Object> param= new HashMap<String, Object>();
		param.put("m_number", m_number);
		return sqlSession.selectList(NS+"othersNumB",param);
	}
	@Override
	public List<Integer> othersNumWhenC(int m_number) {
		Map<String, Object> param= new HashMap<String, Object>();
		param.put("m_number", m_number);
		return sqlSession.selectList(NS+"othersNumC",param);
	}
	@Override
	public List<LikeUser> getAll(Integer loginUserNumber) {
		Map<String, Object> param= new HashMap<String, Object>();
		param.put("loginUserNumber", loginUserNumber);
		return sqlSession.selectList(NS+"getAll",param);
	}
  
}
