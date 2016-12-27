package dao;

import java.util.List;

import logic.SaleItem;

public interface SaleItemDao {

	void create(SaleItem saleItem);

	List<SaleItem> list(Integer saleId);

}
