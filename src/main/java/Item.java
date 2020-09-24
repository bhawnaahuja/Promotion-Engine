package main.java;

public class Item {
 
	
	private String name;
	private Double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Item(String name) {
		super();
		this.name = name;
		
	}
	
}
