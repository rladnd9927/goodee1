package logic;

import java.util.List;

public interface ShopService {

	Item getItemById(Integer id);

	Cart getCart();

	Integer calculateTotalAmount(List<ItemSet> itemList);

	void createUser(User user);

	User getUserByIdPw(String userId, String password);

	Sale checkEnd(User loginUser, Cart cart);

	User getUserById(String id);

	List<Sale> saleList(String id);

	List<SaleItem> saleItemList(Integer saleId);

	List<User> userList();

	List<User> userList(String[] idchks);

}
