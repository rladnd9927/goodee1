package logic;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import dao.SnsDao;

@Service
public class UserServiceImpl implements UserService {

	/*@Autowired
	public SnsDao snsDao;*/

	public List<Integer> getOthersNum(int m_number) { //m_number�� ���� �α��� ������ ȸ����ȣ
		List<Integer> othersNum = new ArrayList<Integer>();
		return othersNum;
	}

}
