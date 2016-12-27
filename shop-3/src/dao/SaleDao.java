package dao;

import java.util.List;

import logic.Sale;

public interface SaleDao {

	Integer getMaxSaleId();

	void createSale(Sale sale);

	List<Sale> list(String id);

}
