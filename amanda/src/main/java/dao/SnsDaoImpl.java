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
	
	public List<Sns> list(int m_number) { //m_number에는 로그인 유저의 회원번호가 들어온다. -> 로그인 유저 말고 좋아요 한 사람의 회원번호를 넘겨줘서 가져올 수 있어야함.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("m_number", m_number);
		return sqlSession.selectList(NS+"list",map);
	}

	public Sns detail(Integer sns_no) {
		return sqlSession.getMapper(SnsMapper.class).detail(sns_no);
	}

	public List<Reply> reply(Integer sns_no) { //SnsMApper에서 쿼리결과인 Reply객체를 리턴받을수 있는지 잘 모르겠음. 에러시 수정할것.
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
