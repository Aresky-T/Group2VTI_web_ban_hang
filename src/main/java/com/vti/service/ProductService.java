package com.vti.service;

import com.vti.entity.Product;
import com.vti.repository.IProductRepository;
import com.vti.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
	@Autowired
	private IProductRepository productService;

	@Override
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@Override
	public Product getProductById(Integer id) {
		return productService.getProductById(id);
	}

	@Override
	public Product getProductByName(String name) {
		return productService.getProductByName(name);
	}

	@Override
	public void createProduct(Product product) {
		productService.createProduct(product);
	}

	@Override
	public void updateProduct(int id, String newName) {
		productService.updateProduct(id, newName);
	}

	@Override
	public void updateProduct(Product product) {
		productService.updateProduct(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productService.deleteProduct(id);
	}

	@Override
	public boolean isProductExistsByID(int id) {
		return productService.isProductExistsByID(id);
	}

	@Override
	public boolean isProductExistsByName(String name) {
		return productService.isProductExistsByName(name);
	}
}
