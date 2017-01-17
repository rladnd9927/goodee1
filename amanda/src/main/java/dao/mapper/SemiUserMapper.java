package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.SemiUser;
import logic.UserProfile;

public interface SemiUserMapper {
	@Select("select * from semi_member where s_number = #{s_number}")
	SemiUser getSemiUserbyNum(int s_number);

	@Select("select * from semi_member")
	List<SemiUser> getSemiUser();
	
	@Select("select * from member_profile where s_number = #{s_number}")
	UserProfile getsemiUserProfile(int s_number);

	@Update("update semi_member set s_score=s_score + #{s_score} where s_number=#{s_number} ")
	void pointUp(Map<Object, Object> map);

	@Update("update semi_member set s_usercount=s_usercount+1 where s_number=#{s_number} ")
	void countUp(Map<Object, Object> map);

	@Delete("delete from semi_member where (select s_score/s_usercount from semi_member where s_usercount >= 5 and s_number=#{s_number}) < 3 and s_number=#{s_number}")
	void semiDelete(Map<Object, Object> map);
}
