package com.example.spring04.model.shop;

//장바구니

public class CartDTO {
	
	
	private int cart_id;
	private String userid;	// 다른 테이블과 join select 할 필드도 추가 테이블 생성시 FK로 지정되었음
	private String name;	// 다른 테이블과 join select 할 필드도 추가	테이블 생성시 FK로 지정되었음
	private int product_code;	// 다른 테이블과 join select 할 필드도 추가 테이블 생성시 FK로 지정되었음
	private String product_name;	// 다른 테이블과 join select 할 필드도 추가 테이블 생성시 FK로 지정되었음
	private int price;
	private int money;
	private int amount;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CartDTO [cart_id=" + cart_id + ", userid=" + userid + ", name=" + name + ", product_code="
				+ product_code + ", product_name=" + product_name + ", price=" + price + ", money=" + money
				+ ", amount=" + amount + "]";
	}
}
