package com.management.grocery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.management.grocery.entity.Grocery;
import com.management.grocery.service.GroceryService;

@RestController
public class GroceryController {
	
	@Autowired
	private GroceryService groceryService;
			
	@GetMapping("/grocery-items")
	public List<Grocery> getGroceryItems(){
		return groceryService.getGroceryItems();
	}
	
	@PostMapping("/grocery-items")
	public Grocery addGroceryItems(@RequestBody Grocery grocery) {
		
		return groceryService.addGroceryItems(grocery);
			
	}
	
	@DeleteMapping("/grocery-items/{id}")
	public String deleteGroceryItems(@PathVariable Long id) {
		groceryService.deleteGrocerItems(id);
		return "deleted";
	}

	@PutMapping("/update-grocery")
	public ResponseEntity<String> updateFroceryDetails(@RequestBody Grocery grocery){
		return groceryService.updateGroceryDetails(grocery);
	}

}
