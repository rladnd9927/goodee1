package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import logic.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}
	
   @Override
   public void create(User user) {
      String sql="insert into useraccount (userId, userName, password, postcode, phoneNo, address, email, birthday) "
            + " values(:userId, :userName, :password, :postCode, :phoneNo, :address, :email, :birthDay)";
      SqlParameterSource param = new BeanPropertySqlParameterSource(user);
      template.update(sql, param);
   }

	@Override
	public User selectIdPw(String userId, String password) {
		String sql = "select * from useraccount where userid = :userId and password = :password";
		Map<String, String>map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("password", password);
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return template.queryForObject(sql, map, mapper);
	}

	@Override
	public User selectId(String id) {
		String sql = "select * from useraccount where userid = :userId";
		Map<String,String> param = new HashMap<String,String>();
		param.put("userId", id);
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return template.queryForObject(sql, param, mapper);
	}

	@Override
	public List<User> list() {
		String sql = "select * from useraccount";
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		
		return template.query(sql, mapper);
	}

	@Override
	public List<User> list(String[] idchks) { //mailForm.shop에서 넘어온 매개변수 idchks
		String ids = "";
		for(int i=0; i<idchks.length;i++){
			ids += "'" + idchks[i] + ((i==(idchks.length-1))?"'":"',");
		}
		String sql = "select * from useraccount where userid in ("+ids+")";
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return template.query(sql, mapper);
	}

}
