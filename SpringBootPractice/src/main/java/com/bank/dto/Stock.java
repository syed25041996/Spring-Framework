package com.bank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Holds properties of all the stocks")
public class Stock {

	@Schema(name = "Stock id")
	private int id;
	@Schema(name = "Stock name")
	private String name;
	@Schema(name = "Stock market name")
	private String marketName;
	@Schema(name = "Stock price")
	private double price;

}