package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.SnsMapper;
import logic.Reply;
import logic.Sns;
import logic.User;

@Repository
public class SnsDaoImpl implements SnsDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "dao.mapper.SnsMapper.";
	
	public List<Sns> list(int m_number) { //m_number���� �α��� ������ ȸ����ȣ�� ���´�. -> �α��� ���� ���� ���ƿ� �� ����� ȸ����ȣ�� �Ѱ��༭ ������ �� �־����.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("m_number", m_number);
		return sqlSession.selectList(NS+"list",map);
	}

	public void insert(Sns sns) {
		sqlSession.getMapper(SnsMapper.class).insert(sns);		
	}

	public void update(Sns sns) {
		sqlSession.getMapper(SnsMapper.class).update(sns);
	}

	public void delete(int sns_no,int m_number) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("sns_no",sns_no);
		map.put("m_number", m_number);
		sqlSession.selectOne(NS+"delete",map);
	}

	public Sns detail(int sns_no, int m_number) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("sns_no",sns_no);
		map.put("m_number", m_number);
		return sqlSession.selectOne(NS+"detail",map);
	}

	public int getMax(int m_number) {
		return sqlSession.getMapper(SnsMapper.class).getMax(m_number);
	}

}
