package dao;

import java.util.List;

import logic.Board;

public interface BoardDao {

	int countAll();

	List<Board> list(Integer pageNum, int limit);

	int getMaxNum();

	void insert(Board board);

	void readCntAdd(int num);

	Board selectOne(int num);

	void refStepAdd(Board board);

	void update(Board board);

	void delete(int num);
	
}
