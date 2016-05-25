package com.michele.item;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class represents the items that can be purchased
 * 
 * @author michele
 *
 */

public class Item implements IItem {
	public static final String BOOK = "book";
	public static final String MED_PROD = "medical product";
	public static final String FOOD = "food";
	public static final String OTHER = "other";

	/**
	 * class attributes: 
	 * - name: the name of item 
	 * - description: a brief description of the item 
	 * - type: an item can be FOOD, MED_PROD, BOOK, OTHER acording to the enum ItemType 
	 * - price: item price without taxes 
	 * - totalTax: total amount of taxes applied to the item 
	 * - taxedPrice: item price plus taxes 
	 * - quantity: number of requested items 
	 * - exempted: this attribute determines if the item is exempted from taxes 
	 * - imported: this attribute determines if the item is imported
	 */

	private String name;
	private String description;
	private String type;

	private BigDecimal price;

	private BigDecimal totalTax;

	private BigDecimal taxedPrice;

	private int quantity;

	private boolean exempted;
	private boolean imported;

	public Item(int quantity, String name, String description, BigDecimal price, String type, boolean imported) {
		setQuantity(quantity);
		setName(name);
		setDescription(description);
		setExempted(false);
		setImported(imported);
		setPrice(price);
		setTotalTax(BigDecimal.ZERO);
		setTaxedPrice(BigDecimal.ZERO);
		setType(type);

	}

	/**
	 * Returns the item name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the item name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the item description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the item description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the item price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Sets the item price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price.setScale(2, RoundingMode.UP);
	}

	/**
	 * Returns the boolean attribute "exempted"
	 */
	public boolean isExempted() {
		return exempted;
	}

	/**
	 * Sets the boolean attribute "exempted"
	 */
	public void setExempted(boolean exempted) {
		this.exempted = exempted;
	}

	/**
	 * Returns the boolean attribute "imported"
	 */
	public boolean isImported() {
		return imported;
	}

	/**
	 * Sets the boolean attribute "imported"
	 */
	public void setImported(boolean imported) {
		this.imported = imported;
	}

	/**
	 * Returns the item total tax
	 */
	public BigDecimal getTotalTax() {
		return totalTax;
	}

	/**
	 * Sets the item total tax
	 */
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * Returns the item taxed price
	 */
	public BigDecimal getTaxedPrice() {
		return taxedPrice;
	}

	/**
	 * Sets the item taxed price
	 */
	public void setTaxedPrice(BigDecimal taxedPrice) {
		this.taxedPrice = taxedPrice;
	}

	/**
	 * Returns the item type
	 */
	public String getType() {
		return type.toString();
	}

	/**
	 * Sets the item type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns item quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets item quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
