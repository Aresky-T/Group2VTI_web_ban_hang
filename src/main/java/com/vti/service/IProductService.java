package com.vti.service;

import com.vti.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IProductService {
	List<Product> getAllProducts();
	Product getProductById(Integer id);
	Product getProductByName(String name);
	void createProduct(Product product);
	void updateProduct(int id, String newName);
	void updateProduct(Product product);
	void deleteProduct(Integer id);
	public boolean isProductExistsByID(int id);
	public boolean isProductExistsByName(String name);
}
