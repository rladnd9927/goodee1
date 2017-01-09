package dao.mapper;

import org.apache.ibatis.annotations.Insert;

import logic.User;

public interface UserMapper {
	
	@Insert("insert into useraccount (userid, username, password, postcode, phoneNo, address, email, birthday) "
			+ " values(#{userId},#{userName},#{password},#{postCode},#{phoneNo},#{address},#{email},#{birthDay})")
	void create(User user);
}
