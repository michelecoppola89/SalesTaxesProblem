package com.michele.tax;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.michele.item.Item;

/**
 * Unit tests for the class TaxComputer.
 * Tested Methods:
 * - evaluateApplicableTaxes()
 * - computeTax()
 * @author michele
 *
 */
public class TaxComputerTest {

	@Test
	public void evaluateApplicableTaxes1() {
		Item item1 = new Item(1, "packet of headache pills", "", new BigDecimal("9.75"), "medical product", false);
		TaxComputer.evaluateApplicableTaxes(item1);

		assertEquals(true, item1.isExempted());

	}

	@Test
	public void evaluateApplicableTaxes2() {
		Item item1 = new Item(1, "book", "", new BigDecimal("12.49"), "book", false);
		TaxComputer.evaluateApplicableTaxes(item1);

		assertEquals(true, item1.isExempted());

	}

	@Test
	public void evaluateApplicableTaxes3() {
		Item item1 = new Item(1, "chocolate bar", "", new BigDecimal("0.85"), "food", false);
		TaxComputer.evaluateApplicableTaxes(item1);

		assertEquals(true, item1.isExempted());

	}

	@Test
	public void evaluateApplicableTaxes4() {
		Item item1 = new Item(1, "music CD", "", new BigDecimal("14.99"), "other", false);
		TaxComputer.evaluateApplicableTaxes(item1);

		assertEquals(false, item1.isExempted());

	}

	@Test
	public void testComputeTax1() {
		Item item1 = new Item(1, "packet of headache pills", "", new BigDecimal("9.75"), "medical product", false);
		TaxComputer.evaluateApplicableTaxes(item1);
		TaxComputer.computeTax(item1);
		assertEquals(new BigDecimal("9.75"), item1.getTaxedPrice());

	}
	
	@Test
	public void testComputeTax2() {
		Item item1 = new Item(1, "music CD", "", new BigDecimal("14.99"), "other", false);
		TaxComputer.evaluateApplicableTaxes(item1);
		TaxComputer.computeTax(item1);
		assertEquals(new BigDecimal("16.49"), item1.getTaxedPrice());

	}
	
	@Test
	public void testComputeTax3() {
		Item item1 = new Item(1, "box of imported chocolates", "", new BigDecimal("11.25"), "food", true);
		TaxComputer.evaluateApplicableTaxes(item1);
		TaxComputer.computeTax(item1);
		assertEquals(new BigDecimal("11.85"), item1.getTaxedPrice());

	}



}
