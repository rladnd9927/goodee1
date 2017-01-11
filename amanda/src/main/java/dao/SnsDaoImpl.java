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

	public Sns detail(Integer sns_no) {
		return sqlSession.getMapper(SnsMapper.class).detail(sns_no);
	}

	public List<Reply> reply(Integer sns_no) { //SnsMApper���� ��������� Reply��ü�� ���Ϲ����� �ִ��� �� �𸣰���. ������ �����Ұ�.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sns_no", sns_no);
		return sqlSession.selectList(NS+"replyList",map);
	}

	public void insert(Sns sns) {
		sqlSession.getMapper(SnsMapper.class).insert(sns);		
	}

	public void update(Sns sns) {
		sqlSession.getMapper(SnsMapper.class).update(sns);
	}

	public void delete(int sns_no) {
		sqlSession.getMapper(SnsMapper.class).delete(sns_no);
	}

}
