package dao.mapper;

import org.apache.ibatis.annotations.Insert;

import logic.User;
//Member
public interface UserMapper {
	
	@Insert("insert into member (m_number, m_email) values(#{m_number},#{m_email})")
	void create(User user);
}
