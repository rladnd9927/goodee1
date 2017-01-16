package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import logic.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "dao.mapper.ReplyMapper.";
	
	@Override
	public List<Reply> replyList(int sns_no, int m_number) { //SnsMApper���� ��������� Reply��ü�� ���Ϲ����� �ִ��� �� �𸣰���. ������ �����Ұ�.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sns_no", sns_no);
		map.put("m_number", m_number);
		return sqlSession.selectList("dao.mapper.ReplyMapper.replyList",map);
	}
}
