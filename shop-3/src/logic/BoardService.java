package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {

	int boardCount();

	List<Board> list(Integer pageNum, int limit);

	void insert(Board board, HttpServletRequest request);

	void readCntAdd(int num);

	Board detail(int num);

	void reply(Board board);

	String getPassword(int num);

	void update(Board board, HttpServletRequest request);

	void delete(int num);

}
