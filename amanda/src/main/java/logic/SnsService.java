package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface SnsService {

	List<Sns> getList(int m_number);

	List<Integer> getOthersNum(int m_number);

	Sns detail(Integer sns_no);

	List<Reply> replyList(Integer sns_no);

	void write(Sns sns, HttpServletRequest request);

	User getUserbyNum(int m_number);

}
