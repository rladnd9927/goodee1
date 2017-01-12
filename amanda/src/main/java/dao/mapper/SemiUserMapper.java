package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import logic.SemiUser;

public interface SemiUserMapper {
	@Select("select * from semi_member where s_number = #{s_number}")
	SemiUser getSemiUserbyNum(int s_number);

	@Select("select * from semi_member")
	List<SemiUser> getSemiUser();
}
