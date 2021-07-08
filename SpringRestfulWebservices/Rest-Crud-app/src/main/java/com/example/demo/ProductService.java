package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired(required=true)
	private ProductRepository repo;
	
	public List<Product> ListAll()
	{
		return repo.findAll();
	}
	
	public Product get(int id)
	{
		return repo.findById(id).get();
	}
	
	public void save(Product product)
	{
		repo.save(product);
	}
	
	public void delete(int id)
	{
		repo.deleteById(id);
	}
	
}
