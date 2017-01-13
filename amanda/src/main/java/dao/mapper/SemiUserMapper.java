package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import logic.SemiUser;
import logic.UserProfile;

public interface SemiUserMapper {
	@Select("select * from semi_member where s_number = #{s_number}")
	SemiUser getSemiUserbyNum(int s_number);

	@Select("select * from semi_member")
	List<SemiUser> getSemiUser();
	
	@Select("select * from member_profile where s_number = #{s_number}")
	UserProfile getsemiUserProfile(int s_number);
}
