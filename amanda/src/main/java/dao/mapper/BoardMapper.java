package dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Board;

public interface BoardMapper {

	@Update("update board set readcnt=readcnt+1 where num=#{num}")
	void readcntadd(Integer num);

	@Select("select num, name, pass, subject,content, readcnt, file1 fileurl, regdate, ref, reflevel, refstep from board where num=#{num}")//file1컬럼의 alias설정을 위해 *를 안쓰고 컬럼을 나열
	Board detail(Integer num);

	@Select("select nvl(max(num),0) from board")
	int maxnum();

	@Insert("insert into board(num, name, pass, subject, content, readcnt, file1, regdate, ref, reflevel, refstep) values(#{num}, #{name}, #{pass}, #{subject}, #{content}, #{readCnt}, #{fileUrl}, sysdate, #{ref}, #{refLevel}, #{refStep})")
	void insert(Board board);

	@Update("update board set refstep = refstep+1 where ref = #{ref} and refstep> #{refStep}")
	void refstepadd(Board board);

	@Update("update board set subject=#{subject}, content=#{content}, file1=#{fileUrl} where num=#{num}")
	void update(Board board);

	@Select("select num,name,pass,subject,content,readcnt,file1 fileurl,regdate,ref,reflevel,refstep from board where num = #{num}")
	Board selectOne(int num);

	@Delete("delete from board where num=#{num}")
	void delete(int num);
	
}
