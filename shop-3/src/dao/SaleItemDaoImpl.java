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

import logic.SaleItem;

@Repository
public class SaleItemDaoImpl implements SaleItemDao {
	private NamedParameterJdbcTemplate template;
	@Autowired
	public void SetDataSource(DataSource dataSource){
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public void create(SaleItem saleItem) {
		String sql = "insert into saleitem (saleId, saleItemid, itemId, quantity, updateTime) values (:sale.saleId, :saleItemid, :item.id, :quantity, :updateTime)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(saleItem);
		template.update(sql, param);
		
	}
	@Override
	public List<SaleItem> list(Integer saleId) {
		String sql = "select * from saleItem where saleid = :saleId";
		Map<String, Integer> param = new HashMap<String,Integer>();
		param.put("saleId", saleId);
		RowMapper<SaleItem> mapper = new BeanPropertyRowMapper<SaleItem>(SaleItem.class);
		return template.query(sql, param,mapper);
	}

}
