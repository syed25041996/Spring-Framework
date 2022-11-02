package com.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.entity.StockEntity;

public interface StockRepo extends JpaRepository<StockEntity, Integer> {

	@Query(value = "select * from stock_entity where name=?1 and market_name=?2", nativeQuery = true)
	List<StockEntity> findByNameAndMarketName(String name, String marketName);
}
