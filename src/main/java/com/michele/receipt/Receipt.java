package com.michele.receipt;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.michele.item.*;

/**
 * This class represents the receipt that shows a resume of purchased items
 * @author michele
 *
 */
public class Receipt implements IReceipt {
	
	/**
	 * class attributes:
	 * - itemList: list that contains purchased items
	 * - salesTaxes: total amount of sales taxes
	 * - totalPrice: total price of the items
	 */
	private ArrayList<Item> itemList;
	private BigDecimal salesTaxes;
	private BigDecimal totalPrice;

	public Receipt() {
		itemList = new ArrayList<Item>();
		salesTaxes = BigDecimal.ZERO;
		totalPrice = BigDecimal.ZERO;
	}

	/**
	 * Returns the list of purchased items
	 */
	public ArrayList<Item> getItemList() {
		return itemList;
	}

	/**
	 * Sets the list of purchased items
	 */
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	/**
	 * Returns the total amount of sales taxes
	 */
	public BigDecimal getSalesTaxes() {
		return salesTaxes;
	}
	
	/**
	 * Sets the total amount of sales taxes
	 */
	public void setSalesTaxes(BigDecimal salesTaxtes) {
		this.salesTaxes = salesTaxtes;
	}

	/**
	 * Returns the total price of purchased items
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Sets the total price of purchased items
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Adds an item to the receipt
	 */
	public void addItemToReceipt(Item item) {
		this.itemList.add(item);

	}

	/**
	 * Calculates the total price of purchased items
	 */
	public void calculateTotal() {
		for (int i = 0; i < this.itemList.size(); i++) {
			this.setTotalPrice(this.getTotalPrice().add(this.itemList.get(i).getTaxedPrice()));
			this.setSalesTaxes(this.getSalesTaxes().add(this.itemList.get(i).getTotalTax()));
		}

	}

	/**
	 * Prints the receipt
	 */
	public void printReceipt() {
		System.out.println("RECEIPT:");
		for (int i = 0; i < this.itemList.size(); i++) {
			System.out.println(this.itemList.get(i).getQuantity()+" "+this.itemList.get(i).getName() + ": " + this.itemList.get(i).getTaxedPrice());
		}
		
		System.out.println("Sales taxes: " + this.getSalesTaxes());
		System.out.println("Total: " + this.getTotalPrice());

	}

}
