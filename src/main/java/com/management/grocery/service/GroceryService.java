package com.management.grocery.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.management.grocery.ExceptionHandling.MyListException;
import com.management.grocery.entity.Grocery;
import com.management.grocery.repository.GroceryRepo;

@Service
public class GroceryService {
	
	@Autowired
	private GroceryRepo groceryRepo;
	
	
	public List<Grocery> getGroceryItems(){
		try {
			return groceryRepo.findAll();
			
		} catch (Exception e) {
			throw new MyListException("Items are not present!");
		}
		
	}
	
	public Grocery addGroceryItems(Grocery grocery) {
		try {
			return groceryRepo.save(grocery);
			
		} catch (Exception e) {
			throw new MyListException("Enter Valid Details");
		}
		
	}
	
	
	public String deleteGrocerItems(Long id) {
		 groceryRepo.deleteById(id);
		 return "deleted";
	}

	public ResponseEntity<String> updateGroceryDetails(Grocery grocery){
		try {
			Grocery newGrocery = new Grocery();
			newGrocery.setId(grocery.getId());
			newGrocery.setName(grocery.getName());
			newGrocery.setPrice(grocery.getPrice());
			newGrocery.setInventory(grocery.getInventory());
			groceryRepo.save(newGrocery);
			return ResponseEntity.ok().body("Successfully updated");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("check you have permissions!");
		}
	}
	

}
