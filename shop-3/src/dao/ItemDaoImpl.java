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

import logic.Item;


/*
 * @Repository 는 기본적으로 @Component임 (하위)
 * Component기능 (해당 멤버, 혹은 클래스를)객체화 +  Model기능.
 * 
 */

@Repository //영속객체 (DB와 연결되어 필요로 하는곳에 데이터를 넘겨줄 수 있게하는 객체)
public class ItemDaoImpl implements ItemDao {
	private NamedParameterJdbcTemplate template;
	
	@Autowired//DataSource객체를 주입하게 된다. -> NamedParameterJdbcTemplate에 바로 Autowired를 붙이면 안된다. NamedParameterJdbcTemplate를 만들지 않았기 때문에
	 		//그래서 setter를 이용하여 dataSource를 넘겨주어 NamedParameterJdbcTemplate객체를 만든다.
	public void setDataSource(DataSource datasource){
		template = new NamedParameterJdbcTemplate(datasource);
	}
	@Override
	public List<Item> findAll() {
		String sql = "select * from item order by id";
		
		/*
		 * Item클래스의 프로퍼티와 item테이블의 컬럼명을 비교하여 같은 이름을 Item객체에 값으로 설정. (자세한 내용은 shop-1의 JavaResources - src/dao/ItemDaoImpl.java 주석 참고)
		 */
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class); //일일히 바뀌는 정보들을 set을 이용해서 넣는 것이 아니라, Rowmapper를 이용해 한번에 Item객체 자체를 넣어준다.
		
		return template.query(sql, mapper);
	}
	@Override
	public Item selectById(Integer id) {
		String sql = "select * from item where id=:id";
		RowMapper<Item> mapper= new BeanPropertyRowMapper<Item>(Item.class);
		Map<String, Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("id",id);
		
		return template.queryForObject(sql, paramMap, mapper);// queryForObject() : 조회된 레코드 수가 한 개인 경우사용
	}
	@Override
	public void create(Item item) {
		String sql = "select nvl(max(id),0) from item";
		int i = template.queryForObject(sql, new HashMap<String,Object>(), Integer.class);
		
		item.setId(++i);
		sql = "insert into item(id,name,price,description,pictureUrl) values(:id, :name, :price, :description, :pictureUrl)";
		
		item.setPictureUrl(item.getPicture().getOriginalFilename());
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(item);
		template.update(sql, paramSource);
	}
	@Override
	public void update(Item item) {
		String sql = "update item set name=:name, price=:price, pictureUrl=:pictureUrl, description=:description where id=:id";
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(item);
		template.update(sql, paramSource);
		
	}
	@Override
	public void delete(Integer id) {
		String sql = "delete from item where id=:id";
		Map<String, Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("id",id);
		template.update(sql, paramMap);
	}

}
