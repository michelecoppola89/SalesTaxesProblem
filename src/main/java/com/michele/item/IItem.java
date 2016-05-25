package com.michele.item;

import java.math.BigDecimal;

/**
 * Interface for Item
 * @author michele
 *
 */

public interface IItem {
	
	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public BigDecimal getPrice();

	public void setPrice(BigDecimal price);

	public boolean isExempted();

	public void setExempted(boolean exempted);

	public boolean isImported();

	public void setImported(boolean imported);

	public BigDecimal getTotalTax();

	public void setTotalTax(BigDecimal totalTax);

	public BigDecimal getTaxedPrice();

	public void setTaxedPrice(BigDecimal taxedPrice);

	public String getType();

	public void setType(String type);

	public int getQuantity();

	public void setQuantity(int quantity);


}
