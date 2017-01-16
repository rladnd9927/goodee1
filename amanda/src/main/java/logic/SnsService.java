package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface SnsService {

	List<Sns> getList(int m_number);

	List<Integer> getOthersNum(int m_number);

	Sns detail(Integer sns_no, int m_number);

	List<Reply> replyList(int sns_no, int m_number);

	void write(Sns sns, HttpServletRequest request);

	User getUserbyNum(int m_number);

	void update(Sns sns, HttpServletRequest request);

	void delete(int sns_no, int m_number);

	String ObjectToJSONString(Object rawData) throws JsonProcessingException;

}
