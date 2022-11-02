package com.bank.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.Stock;
import com.bank.entity.StockEntity;
import com.bank.exception.StockNotFoundException;
import com.bank.repo.StockRepo;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepo stockRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Stock createStock(Stock stock, String authToken) {
		// get entity
		// set dto in entity
		// save entity
		// convert entity to dto
		// return dto
		StockEntity stockEntity = this.modelMapper.map(stock, StockEntity.class);

		stockRepo.save(stockEntity);

		return this.modelMapper.map(stockEntity, Stock.class);
	}

	@Override
	public List<Stock> getAllStocks() {
		// get stocks from entity
		// create a new arraylist for dto
		// convert single value of entity to dto
		// add it to dtoarray
		List<StockEntity> stockEntities = stockRepo.findAll();

		List<Stock> stocks = stockEntities.stream().map(s -> this.modelMapper.map(s, Stock.class))
				.collect(Collectors.toList());

		return stocks;

	}

	@Override
	public Stock getStock(int id) {
		StockEntity stockEntity = stockRepo.findById(id)
				.orElseThrow(() -> new StockNotFoundException("Stock not found with id " + id));

		return this.modelMapper.map(stockEntity, Stock.class);
	}

	@Override
	public Stock updateStock(Stock stock, int id) {

		// get the stock from id
		// update the entity using getters
		// set the dto using setters
		// return dto
		StockEntity stockEntity = stockRepo.findById(id)
				.orElseThrow(() -> new StockNotFoundException("Stock not found with id " + id));

		stockEntity.setId(stock.getId());
		stockEntity.setName(stock.getName());
		stockEntity.setMarketName(stock.getMarketName());
		stockEntity.setPrice(stock.getPrice());

		stockRepo.save(stockEntity);

		return this.modelMapper.map(stockEntity, Stock.class);

	}

	@Override
	public void deleteStock(int id) {
		if (stockRepo.existsById(id)) {
			stockRepo.deleteById(id);
		} else {
			throw new StockNotFoundException("Stock not found with id " + id);
		}

	}

	@Override
	public List<Stock> getAllStocksWithNameAndMarketName(String name, String marketName) {
		List<StockEntity> stockEntities = stockRepo.findByNameAndMarketName(name, marketName);

		List<Stock> stocks = stockEntities.stream().map(s -> this.modelMapper.map(s, Stock.class))
				.collect(Collectors.toList());

		// testing
		List<StockEntity> entites = this.stockRepo.findByNameAndMarketName("syed", "syed");
		System.out.println("asdadasdasdasd===== " + entites);

		return stocks;
	}

}
