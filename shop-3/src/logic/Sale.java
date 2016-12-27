package logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Sale {
	private Integer saleId; //주문번호. 주문이 생길때마다 1씩 증가하여 sale테이블의 key값이 될것이다.
	private User user; //주문한 고객의 정보가진 객체 (주문고객의 login정보를 가지고 있음)
	private Timestamp updateTime; //주문 날짜와 시간.
	//주문상품 목록
	private List<SaleItem> saleItemList=new ArrayList<SaleItem>();
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public List<SaleItem> getSaleItemList() {
		return saleItemList;
	}
	public void setSaleItemList(List<SaleItem> saleItemList) {
		this.saleItemList = saleItemList;
	}
	
}
