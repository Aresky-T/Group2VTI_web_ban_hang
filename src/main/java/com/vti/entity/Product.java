package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`Product`")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "ProductID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ProductName", length = 50, nullable = false, unique = true)
	private String name;

	@Column(name = "TypeProduct", length = 50, nullable = false)
	private String type;

	@Column(name = "Price")
	private int price;

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString(){
		return "Product: [ Id: " + id + ", Product Name: " + name + ", Type: " + type + ", Price: " + price + " ]";
	}
}
