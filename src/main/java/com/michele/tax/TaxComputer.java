package com.michele.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.michele.item.*;

/**
 * This class contains static methods
 * @author michele
 *
 */
public class TaxComputer {
	
	/**
	 * Constants thar represent the rate of taxes
	 */
	private static final double BASIC = 10.0;
	private static final double IMPORTED = 5.0;

	/**
	 * This method determines if the kind of taxes that are applicable to an item according to item type
	 * @param item
	 */
	public static void evaluateApplicableTaxes(Item item) {
		if (item.getType().equals(ItemType.BOOK.toString())) {

			item.setExempted(true);

		} else if (item.getType().equals(ItemType.MED_PROD.toString())) {
			item.setExempted(true);

		} else if (item.getType().equals(ItemType.FOOD.toString())) {
			item.setExempted(true);

		}

	}

	/**
	 * This method compute the total tax applicable to an item
	 * 
	 * @param item
	 * @return BigDecimal totalTax
	 */
	public static BigDecimal computeTax(Item item) {

		BigDecimal totalTax = BigDecimal.ZERO;

		if (!item.isExempted()) {
			totalTax = totalTax.add(calculateTax(new BigDecimal(BASIC), item.getPrice()));

		}
		if (item.isImported()) {
			totalTax = totalTax.add(calculateTax(new BigDecimal(IMPORTED), item.getPrice()));
		}

		item.setTaxedPrice(item.getPrice().add(totalTax));
		item.setTotalTax(totalTax);
		return totalTax;
	}

	/**
	 * 
	 * Calculates and rouds up a tax to the nearest 0.05
	 * 
	 * @param rate
	 * @param price
	 * @return Big Decimal roundedTax
	 * 
	 */
	private static BigDecimal calculateTax(BigDecimal rate, BigDecimal price) {

		BigDecimal tax = (rate.multiply(price)).divide(new BigDecimal(100));
		BigDecimal roundedTax = tax.multiply(new BigDecimal("20")).setScale(0, RoundingMode.UP).setScale(2);

		roundedTax = roundedTax.divide(new BigDecimal("20"), RoundingMode.UP);

		return roundedTax;

	}

}
