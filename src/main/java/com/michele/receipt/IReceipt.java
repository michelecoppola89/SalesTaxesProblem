package com.michele.receipt;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.michele.item.Item;

/**
 * Interface for Receipt
 * @author michele
 *
 */
public interface IReceipt {

	public ArrayList<Item> getItemList();

	public void setItemList(ArrayList<Item> itemList);

	public BigDecimal getSalesTaxes();

	public void setSalesTaxes(BigDecimal salesTaxtes);

	public BigDecimal getTotalPrice();

	public void setTotalPrice(BigDecimal totalPrice);

	public void addItemToReceipt(Item item);

	public void calculateTotal();

	public void printReceipt();

}
