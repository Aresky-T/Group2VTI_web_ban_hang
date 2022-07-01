package com.vti.repository;

import com.vti.entity.Product;

import java.util.List;

public interface IProductRepository {
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
