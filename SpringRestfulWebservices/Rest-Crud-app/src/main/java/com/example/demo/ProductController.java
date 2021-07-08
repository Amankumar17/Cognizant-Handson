package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping(path="/products")
	public List<Product> list()
	{
		return service.ListAll();
	}
	
	@GetMapping(path="/product/{id}")
	public ResponseEntity<Product> get(@PathVariable int id){
		try {
			Product product = service.get(id);
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/products")
	public void add(@RequestBody Product product)
	{
		service.save(product);
	}
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable int id)
	{
		service.delete(id);
	}
	
	@PutMapping("products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product,@PathVariable int id)
	{
		try {
			Product exsProduct = service.get(id);
			exsProduct.setName(product.getName());
			exsProduct.setPrice(product.getPrice());
			service.save(exsProduct);
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
