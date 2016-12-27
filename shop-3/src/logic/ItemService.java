package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ItemService {

	List<Item> getItemList();
	Item getItemById(Integer id);
	void entryItem(Item item, HttpServletRequest request);
	void itemUpdate(Item item, HttpServletRequest request);
	void itemDelete(Integer id);
}
