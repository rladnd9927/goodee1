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

import logic.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public int countAll() {
		String sql = "select count(*) from board";
		
		return template.queryForObject(sql, new HashMap<String,Object>(),Integer.class);
	}

	   @Override
	   public List<Board> list(Integer pageNum, int limit) {
	      String sql = "select * from "
	            + " (select rownum rnum, num, name, "
	            + " subject, content, file1 fileurl, "
	            + " regdate, ref, reflevel, refstep, "
	            + " pass, readcnt from "
	            + " ( select * from board "
	            + " order by ref desc, refstep asc))"
	            + " where rnum >= :startrow "
	            + " and rnum <= :endrow";
	      int startrow = (pageNum - 1) * limit + 1;
	      int endrow = startrow + limit - 1;
	      Map<String, Integer> map = new HashMap<String, Integer>();
	      map.put("startrow", startrow);
	      map.put("endrow", endrow);
	      RowMapper<Board> mapper = new BeanPropertyRowMapper<Board>(Board.class);
	      return template.query(sql, map, mapper);
	   }
	@Override
	public int getMaxNum() {
		String sql = "select nvl(max(num),0) from board";
		return template.queryForObject(sql, new HashMap<String,Object>(), Integer.class);
	}
	@Override
	public void insert(Board board) {
		String sql = "insert into board (num,name,pass,subject,content,readcnt,file1,regDate,ref,reflevel,refstep) values(:num, :name, :pass, :subject, :content, :readCnt, :fileUrl, sysdate, :ref, :refLevel, :refStep)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(board);
		template.update(sql, param);
		
	}
	@Override
	public void readCntAdd(int num) {
		String sql = "update board set readcnt=readcnt+1 where num= :num";
		Map<String, Integer>map = new HashMap<String,Integer>();
		map.put("num", num);
		template.update(sql, map);
	}
	@Override
	public Board selectOne(int num) {
		String sql = "select num,name,pass,subject,content,readcnt,file1 fileurl,regdate,ref,reflevel,refstep from board where num = :num";
		Map<String, Integer>map = new HashMap<String,Integer>();
		map.put("num", num);
		RowMapper<Board> mapper = new BeanPropertyRowMapper<Board>(Board.class);
		
		return template.queryForObject(sql, map, mapper);
	}
	@Override
	public void refStepAdd(Board board) {
		String sql = "update board set refstep = refstep+1 where ref = :ref and refstep> :refStep";
		SqlParameterSource param = new BeanPropertySqlParameterSource(board);
		template.update(sql, param);
	}
	@Override
	public void update(Board board) {
		String sql = "update board set subject=:subject, content=:content, file1=:fileUrl where num=:num";
		SqlParameterSource param = new BeanPropertySqlParameterSource(board);
		template.update(sql, param);
	}
	@Override
	public void delete(int num) {
		String sql = "delete from board where num=:num";
		Map<String, Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("num",num);
		template.update(sql, paramMap);
	}

}
