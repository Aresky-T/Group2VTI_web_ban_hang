package com.vti.controller;

import com.vti.entity.Product;
import com.vti.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	@Autowired
	private IProductService productController;

	@GetMapping()
	public List<Product> getAllProducts(){
		return productController.getAllProducts();
	}

	@GetMapping(value="/{id}")
	public Product getProductById(@PathVariable(value = "id") Integer id){
		return productController.getProductById(id);
	}

	@GetMapping(value = "/{name}")
	public Product getProductByName(@PathVariable(value = "name") String name){
		return productController.getProductByName(name);
	}

	@PostMapping()
	public void createProduct(@RequestBody Product product){
		productController.createProduct(product);
	}

	@PutMapping(value = "/{id}")
	public void updateProduct(@PathVariable(value = "id") Integer id, @RequestBody Product product){
		product.setId(id);
		productController.updateProduct(product);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteProduct(@PathVariable(value = "id") Integer id){
		productController.deleteProduct(id);
	}
}
