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
	
	@Insert("insert into semi_member (s_number, s_email, s_password, s_name, s_score, gender, s_usercount) "
			+ " values(#{semiuser.s_number}, #{semiuser.s_email}, #{semiuser.s_password}, #{semiuser.s_name}, 0, #{semiuser.gender}, 0)")
	void createsemi(UserProfile userprofile);

	@Select("select * from member_profile where m_number = #{m_number}")
	UserProfile getUserProfile(int m_number);
	
	/*@Insert("insert into member_profile (m_number, m_picture1, m_picture2, m_picture3, "*/

	@Insert("insert into member_profile (m_number, m_picture1, m_picture2, m_picture3, "
			+ " m_nickname, m_school ,m_major ,m_job, m_area, m_birthday, m_height, m_bloodtype, "
			+ " m_religion, m_smoking, m_drinking, m_bodytype, m_character, s_number, m_score) "
			+ " values(#{semiuser.s_number}, #{m_pictureUrl1}, #{m_pictureUrl2}, #{m_pictureUrl3}, "
			+ " #{m_nickname}, #{m_school}, #{m_major}, #{m_job}, #{m_area}, #{m_birthday}, "
			+ " #{m_height}, #{m_bloodtype}, #{m_religion}, #{m_smoking}, #{m_drinking}, #{m_bodytype}, "
			+ " #{m_character}, #{semiuser.s_number}, 0)")
	void createprofile(UserProfile userprofile);

	@Select("select nvl(max(s_number),0) from semi_member")
	int getNum();

}
