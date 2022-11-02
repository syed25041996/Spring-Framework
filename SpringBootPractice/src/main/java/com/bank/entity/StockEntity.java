package com.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Holds properties of all the stocks")
public class StockEntity {

	@Schema(name = "Stock id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Schema(name = "Stock name")
	private String name;
	@Schema(name = "Stock market name")
	private String marketName;
	@Schema(name = "Stock price")
	private double price;

}
