package dao;

import java.util.List;

public interface LikeUserDao {

	List<Integer> othersNumWhenA(int m_number);
	List<Integer> othersNumWhenB(int m_number);
	int  getMnumFromLikeTable(int loginUserNumber);
  
}
