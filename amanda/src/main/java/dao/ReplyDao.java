package dao;

import java.util.List;

import logic.Reply;

public interface ReplyDao {

	List<Reply> replyList(int sns_no, int m_number);

}
