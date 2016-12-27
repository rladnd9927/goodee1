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

import logic.Sale;

@Repository
public class SaleDaoImpl implements SaleDao{
   private NamedParameterJdbcTemplate template;
   @Autowired
   public void SetDataSource(DataSource dataSource){
      template = new NamedParameterJdbcTemplate(dataSource);
   }
   @Override
   public Integer getMaxSaleId() {
      String sql = "select nvl(max(saleid),0) from sale";
      int i = template.queryForObject(sql, new HashMap(), Integer.class);  //queryForObject() : 조회된 레코드 수가 한 개인 경우사용 , i : sale테이블의 최대 saleId값을 저장하고 있는변수
      return i+1; //현재 sale 테이블에 있는 최대 saleId값을  하나 증가시킴.
   }

   @Override
   public void createSale(Sale sale) {
      String sql = "insert into sale (saleId, userId, updateTime) values (:saleId, :user.userId, :updateTime)"; //:user.userId -> sale.getUser().getUserId()와 같은 형태임 (이미 sale안에는 user정보가 다 있고, 그 user객체의 내용을 가져오는것임)
      SqlParameterSource param = new BeanPropertySqlParameterSource(sale);
      template.update(sql, param);
   }
@Override
public List<Sale> list(String id) {
	String sql = "select * from sale where userid = :userId";
	Map<String, String> param = new HashMap<String,String>();
	param.put("userId", id);
	RowMapper<Sale> mapper = new BeanPropertyRowMapper<Sale>(Sale.class);
	return template.query(sql, param,mapper);
}
}