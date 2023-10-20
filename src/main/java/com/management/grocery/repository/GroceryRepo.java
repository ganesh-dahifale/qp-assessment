package com.management.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.grocery.entity.Grocery;

public interface GroceryRepo extends JpaRepository<Grocery, Long>{
	

}
