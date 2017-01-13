package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.BoardMapper;
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

	public User getUserbyNum(int m_number) {
		return sqlSession.getMapper(UserMapper.class).getUserbyNum(m_number);
	}

	public void createSemi(UserProfile userprofile) {
		sqlSession.getMapper(UserMapper.class).createsemi(userprofile);
	}

	public void createProfile(UserProfile userprofile) {
		sqlSession.getMapper(UserMapper.class).createprofile(userprofile);
	}

	public int getNum() {
		return sqlSession.getMapper(UserMapper.class).getNum();
	}

	public void delete(int num) {
		sqlSession.getMapper(UserMapper.class).delete(num);
	}

	public UserProfile getUserProfile(int m_number) {
		return sqlSession.getMapper(UserMapper.class).getUserProfile(m_number);
	}

	public List<User> userlist() {
		return sqlSession.selectList(NS + "userlist"); 
	}
	
	   public List<User> likelist(int userNum, User myNum, int c_number) {
	      Map<String, Object> param = new HashMap<String, Object>();
	      //param.put("num", num);
	      param.put("userNum", userNum); 
	      param.put("c_number", c_number);
	      param.put("myNum",  myNum.getM_number());
	      System.out.println(param);
	      return sqlSession.selectList(NS + "likelist", param);
	      
	   }

	   public List<User> likelist2(int userNum, User myNum) {
	      Map<String, Object> param = new HashMap<String, Object>();
	      //param.put("num", num);
	      param.put("userNum", userNum); 
	      param.put("myNum",  myNum.getM_number());
	      return sqlSession.selectList(NS + "likelist2", param);
	   }

	   public String ser(int userNum, User myNum) {
	      Map<String, Object> param = new HashMap<String, Object>();
	      param.put("userNum", userNum);
	      param.put("myNum",  myNum.getM_number());  
	      System.out.println( myNum.getM_number()+"User 확인 ㅎ");
	      System.out.println(param+"ser param값");
	      return sqlSession.selectOne(NS + "ser", param); 
	   }
	   
	   public String aer(int userNum, User myNum) {
	      Map<String, Object> param = new HashMap<String, Object>();
	      param.put("userNum", userNum);
	      param.put("myNum", myNum.getM_number());  
	      System.out.println(userNum+"++++"+myNum);
	      System.out.println("누름? 안누름?");
	      return sqlSession.selectOne(NS + "aer", param);  
	   }

	   public List<User> likelist(int userNum, User myNum) {
	      Map<String, Object> param = new HashMap<String, Object>();
	      param.put("userNum", userNum); 
	      param.put("myNum",  myNum.getM_number());
	      return sqlSession.selectList(NS + "likelist3", param);
	   }

	   public List<User> nolist(int userNum, User myNum) {
	      Map<String, Object> param = new HashMap<String, Object>();
	      param.put("userNum", userNum); 
	      param.put("myNum",  myNum.getM_number());
	      return sqlSession.selectList(NS + "nolist", param);
	   }



}
