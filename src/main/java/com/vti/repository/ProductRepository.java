package com.vti.repository;

import com.vti.Utils.HibernateUtils;
import com.vti.entity.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
	private HibernateUtils hibernateUtils;

	public ProductRepository(){
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Query<Product> query = session.createQuery("FROM Product ORDER BY id ASC");
			return query.list();
		} finally {
			if (session != null){
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Product getProductById(Integer id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Product product = session.get(Product.class, id);
			return product;
		} finally {
			if (session != null){
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Product getProductByName(String name) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Query<Product> query = session.createQuery("FROM Product WHERE name =: nameParam");
			query.setParameter("nameParam", name);
			Product product = query.uniqueResult();
			return product;
		} finally {
			if (session != null){
				session.close();
			}
		}
	}

	@Override
	public void createProduct(Product product) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		} finally {
			if (session != null){
				session.close();
			}
		}
	}

	@Override
	public void updateProduct(int id, String newName) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			Product product = (Product)session.load(Product.class, id);
			product.setName(newName);
			session.getTransaction().commit();
		} finally {
			if (session != null){
				session.close();
			}
		}
	}

	@Override
	public void updateProduct(Product product) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
		} finally {
			if (session != null){
				session.close();
			}
		}
	}

	@Override
	public void deleteProduct(Integer id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			Product product = (Product) session.load(Product.class, id);
			session.delete(product);
			session.getTransaction().commit();
		} finally {
			if (session != null){
				session.close();
			}
		}
	}

	@Override
	public boolean isProductExistsByID(int id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Product product = getProductById(id);
			if(product == null){
				return false;
			}
			return true;
		} finally {
			if (session != null){
				session.close();
			}
		}
	}

	@Override
	public boolean isProductExistsByName(String name) {
		Session session = null;
		try {
			Product product = getProductByName(name);
			if(product == null){
				return false;
			}
			return true;
		} finally {
			if (session != null){
				session.close();
			}
		}
	}
}
