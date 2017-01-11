package dao;

import java.util.List;

import logic.Reply;
import logic.Sns;
import logic.User;

public interface SnsDao {

	List<Sns> list(int m_number);

	Sns detail(Integer sns_no);

	List<Reply> reply(Integer sns_no);

	void insert(Sns sns);

	void update(Sns sns);

	void delete(int sns_no);
}
