package dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.SemiUser;
import logic.User;
import logic.UserProfile;
//Member
public interface UserMapper {

	@Select("select * from member where m_number = #{m_number}")
	User getUserbyNum(int m_number);
	
	@Insert("insert into semi_member (m_number, m_email, m_password, m_name, gender) "
			+ "values(#{m_number},#{m_email},#{m_password}, #{m_name}, #{gender})")
	void createsemi(UserProfile userprofile);
	
	@Select("select * from member_profile where m_number = #{m_number}")
	UserProfile getUserProfile(int m_number);

	@Select("select * from member_profile where m_number = #{m_number}")
	UserProfile detail(int m_number);
	
	
	/*@Insert("insert into member_profile (m_number, m_picture1, m_picture2, m_picture3, "
			+ " m_nickname, m_school ,m_major ,m_job, m_area, m_birthday, m_height, m_bloodtype, "
			+ " m_religion, m_smoking, m_drinking, m_bodytype, m_character, s_number, m_score) "
			+ " values(#{m_number}, #{m_picture1}, #{m_picture2}, #{m_picture3}, "
			+ " #{m_nickname}, #{m_school}, #{m_major}, #{m_job}, #{m_area}, #{m_birthday}, "
			+ " #{m_height}, #{m_bloodtype}, #{m_religion}, #{m_smoking}, #{m_drinking}, #{m_bodytype}, "
			+ " #{m_character}, #{s_number}, #{m_score})")
	void createprofile(UserProfile userprofile);*/

	/*@Insert("insert into semi_member (m_number, m_email, m_password, m_name, gender) "
			+ "values(#{m_number},#{m_email},#{m_password}, #{m_name}, #{gender})")
	void create(SemiUser semiuser);*/
	
	/*@Insert("insert into member_profile (m_number, m_picture1, m_picture2, m_picture3, "
			+ " m_nickname, m_school ,m_major ,m_job, m_area, m_birthday, m_height, m_bloodtype, "
			+ " m_religion, m_smoking, m_drinking, m_bodytype, m_character, s_number, m_score) "
			+ " values(#{m_number}, #{m_picture1}, #{m_picture2}, #{m_picture3}, "
			+ " #{m_nickname}, #{m_school}, #{m_major}, #{m_job}, #{m_area}, #{m_birthday}, "
			+ " #{m_height}, #{m_bloodtype}, #{m_religion}, #{m_smoking}, #{m_drinking}, #{m_bodytype}, "
			+ " #{m_character}, #{s_number}, #{m_score})")
	void create(UserProfile userprofile);*/
}
