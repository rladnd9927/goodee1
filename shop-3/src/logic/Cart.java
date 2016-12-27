package logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

public class Cart {
	private List<ItemSet> itemList = new ArrayList<ItemSet>();
	
	public List<ItemSet> getItemList(){
		
		return itemList;
	}
	public void push(ItemSet itemSet){
		Iterator<ItemSet> iter= itemList.iterator(); //초기에는 itemList에 아무것도 없음 (카트에 아무것도 안담겨있음)
		
		ItemSet is = null;
		
		while(iter.hasNext()){ //맨 처음에는 목록이 없기에, false일 것.
			is=iter.next();
			if(is.getItem().getId()==itemSet.getItem().getId()){
				is.setQuantity(is.getQuantity()+itemSet.getQuantity());
				return;
			}
		}
		itemList.add(itemSet);
	}
	public String remove(int index) {
		ItemSet itemSet = itemList.get(index);
		itemList.remove(index);
		
		return itemSet.getItem().getName();
	}
	public boolean isEmpty() {
		if(itemList == null || itemList.isEmpty()){
			return true;
		}
		return false;
	}
	public void clearAll(HttpSession session) {
		itemList = new ArrayList<ItemSet>();
		session.setAttribute("CART", this);
	}
}
