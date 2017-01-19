package dao.mapper;


import org.apache.ibatis.annotations.Select;

public interface LikeUserMapper {

	@Select("select distinct m_number from(select decode(m_number, 0, m_number, -1) m_number from I_LIKE_MEMBER) where m_number != -1 ") 
	 int  getMnumFromLikeTable(int loginUserNumber);

}
