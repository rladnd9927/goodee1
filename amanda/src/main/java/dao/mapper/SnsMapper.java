package dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.Sns;
import logic.User;

public interface SnsMapper {
	@Select("select M_NUMBER, SNS_NO, SNS_PICTURE fileurl, SNS_SUBJECT, SNS_CONTENT, SNS_DATE from sns where sns_no=#{SNS_NO}")//file1�÷��� alias������ ���� *�� �Ⱦ��� �÷��� ����
	Sns detail(Integer sns_no);

	@Insert("insert into SNS(M_NUMBER, SNS_NO, SNS_PICTURE, SNS_SUBJECT, SNS_CONTENT, SNS_DATE) values(#{m_number}, #{sns_no},  #{fileUrl}, #{sns_subject}, #{sns_content}, sysdate)")
	void insert(Sns sns);

}
