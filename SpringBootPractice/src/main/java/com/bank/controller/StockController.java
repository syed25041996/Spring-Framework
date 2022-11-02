package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.Stock;
import com.bank.service.StockService;

@RestController
@RequestMapping("/marketplace")
public class StockController {

	@Autowired
	StockService stockService;

	// create a stock
	@PostMapping("/stock")
	public ResponseEntity<Stock> createStock(@RequestBody Stock stock,
			@RequestHeader(name = "auth-token") String authToken) {
		return new ResponseEntity<Stock>(stockService.createStock(stock, authToken), HttpStatus.OK);
	}

	// get all stocks
	@GetMapping("/stocks")
	public List<Stock> getAllStocks() {
		return this.stockService.getAllStocks();
	}

	// get stock by id
	@GetMapping("/stock/{id}")
	public ResponseEntity<Stock> getStock(@PathVariable(name = "id") int id) {

		return new ResponseEntity<Stock>(this.stockService.getStock(id), HttpStatus.OK);
	}

	@GetMapping("/stock/{name}/{marketName}")
	public ResponseEntity<List<Stock>> getStockByNameAndMarketName(@PathVariable(name = "name") String name,
			@PathVariable(name = "marketName") String marketName) {

		return new ResponseEntity<List<Stock>>(this.stockService.getAllStocksWithNameAndMarketName(name, marketName),
				HttpStatus.OK);
	}

	// update a stock
	@PutMapping("/stock/{id}")
	public ResponseEntity<Stock> updateStock(@PathVariable(name = "id") int id, @RequestBody Stock stock) {

		return new ResponseEntity<Stock>(this.stockService.updateStock(stock, id), HttpStatus.OK);
	}

	// delete a stock
	// get stock by id
	@DeleteMapping("/stock/{id}")
	public void deleteStock(@PathVariable(name = "id") int id) {

		this.stockService.deleteStock(id);
	}
}
