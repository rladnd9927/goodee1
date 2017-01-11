package dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Sns;
import logic.User;

public interface SnsMapper {
	@Select("select M_NUMBER, SNS_NO, SNS_PICTURE fileurl, SNS_SUBJECT, SNS_CONTENT, SNS_DATE from sns where sns_no=#{SNS_NO}")//file1컬럼의 alias설정을 위해 *를 안쓰고 컬럼을 나열
	Sns detail(Integer sns_no);

	@Insert("insert into SNS(M_NUMBER, SNS_NO, SNS_PICTURE, SNS_SUBJECT, SNS_CONTENT, SNS_DATE) values(#{m_number}, #{sns_no},  #{fileUrl}, #{sns_subject}, #{sns_content}, sysdate)")
	void insert(Sns sns);

	@Update("update sns set SNS_SUBJECT = #{sns_subject}, SNS_CONTENT = #{SNS_CONTENT}, SNS_PICTURE = #{fileUrl} where SNS_NO = #{sns_no}")
	void update(Sns sns);

	@Delete("delete from sns where sns_no = #{sns_no}")
	void delete(int sns_no);

}
