package com.bank.service;

import java.util.List;

import com.bank.dto.Stock;

public interface StockService {

	Stock createStock(Stock stock, String authToken);
	
	List<Stock> getAllStocks();
	
	List<Stock> getAllStocksWithNameAndMarketName(String name, String marketName);
	
	Stock getStock(int id);
	
	Stock updateStock(Stock stock, int id);
	
	void deleteStock(int id);
}
