package com.example.spring04.model.shop;

import java.util.ArrayList;
import java.util.List;

public class CartList {
	private List<CartDTO> carts;
	
	public List<CartDTO> getCarts() {
		return carts;
	}
	
	public void setCarts(List<CartDTO> carts) {
		this.carts = carts;
	}
}
	


//package net.viralpatel.spring3.form;
//
//import java.util.List;
//
//public class ContactForm {
//
//	private List<Contact> contacts;
//
//	public List<Contact> getContacts() {
//		return contacts;
//	}
//
//	public void setContacts(List<Contact> contacts) {
//		this.contacts = contacts;
//	}
//}