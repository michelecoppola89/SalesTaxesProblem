package com.michele.receipt;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.*;

import com.michele.item.Item;
import com.michele.receipt.Receipt;
import com.michele.tax.TaxComputer;

/**
 * Unit tests for the class Receipt. Tested methods: 
 * -calculateTotal()
 * 
 * @author michele
 *
 */
public class ReceiptTest {

	@Before
	public void beforeEachTest() {

		System.out.println("-------------------------------------------------------");

	}

	@After
	public void afterEachTest() {

		System.out.println("-------------------------------------------------------");
		System.out.println();

	}

	/**
	 * Three tests for the method calculateTotal(). The inputs are those
	 * specified in the problem text.
	 */

	@Test
	public void testCalculateTotal1() {
		System.out.println("TEST1");
		System.out.println("-------------------------------------------------------");

		Receipt receipt = new Receipt();
		
		System.out.println("INPUT");
		Item item1 = new Item(1, "book", "", new BigDecimal("12.49"), "book", false);
		System.out.println(item1.getQuantity()+" "+item1.getName()+" at "+item1.getPrice());
		
		TaxComputer.evaluateApplicableTaxes(item1);
		TaxComputer.computeTax(item1);
		receipt.addItemToReceipt(item1);

		Item item2 = new Item(1, "music CD", "", new BigDecimal("14.99"), "other", false);
		System.out.println(item2.getQuantity()+" "+item2.getName()+" at "+item2.getPrice());
		
		TaxComputer.evaluateApplicableTaxes(item2);
		TaxComputer.computeTax(item2);
		receipt.addItemToReceipt(item2);

		Item item3 = new Item(1, "chocolate bar", "", new BigDecimal("0.85"), "food", false);
		System.out.println(item3.getQuantity()+" "+item3.getName()+" at "+item3.getPrice());
		
		TaxComputer.evaluateApplicableTaxes(item3);
		TaxComputer.computeTax(item3);
		receipt.addItemToReceipt(item3);

		receipt.calculateTotal();
		System.out.println();
		receipt.printReceipt();

		assertEquals(new BigDecimal("29.83"), receipt.getTotalPrice());
		assertEquals(new BigDecimal("1.50"), receipt.getSalesTaxes());

	}

	@Test
	public void testCalculateTotal2() {
		System.out.println("TEST2");
		System.out.println("-------------------------------------------------------");
		
		Receipt receipt = new Receipt();
		
		System.out.println("INPUT");
		Item item1 = new Item(1, "imported box of chocolates", "", new BigDecimal("10.00"), "food", true);
		System.out.println(item1.getQuantity()+" "+item1.getName()+" at "+item1.getPrice());
		
		TaxComputer.evaluateApplicableTaxes(item1);
		TaxComputer.computeTax(item1);
		receipt.addItemToReceipt(item1);

		Item item2 = new Item(1, "imported bottle of perfume", "", new BigDecimal("47.50"), "other", true);
		System.out.println(item2.getQuantity()+" "+item2.getName()+" at "+item2.getPrice());
		
		TaxComputer.evaluateApplicableTaxes(item2);
		TaxComputer.computeTax(item2);
		receipt.addItemToReceipt(item2);

		receipt.calculateTotal();
		System.out.println();
		receipt.printReceipt();

		assertEquals(new BigDecimal("65.15"), receipt.getTotalPrice());
		assertEquals(new BigDecimal("7.65"), receipt.getSalesTaxes());
	}

	@Test
	public void testCalculateTotal3() {
		System.out.println("TEST3");
		System.out.println("-------------------------------------------------------");
		
		Receipt receipt = new Receipt();
		
		System.out.println("INPUT");
		Item item1 = new Item(1, "imported bottle of perfume", "", new BigDecimal("27.99"), "other", true);
		System.out.println(item1.getQuantity()+" "+item1.getName()+" at "+item1.getPrice());
		
		TaxComputer.evaluateApplicableTaxes(item1);
		TaxComputer.computeTax(item1);
		receipt.addItemToReceipt(item1);

		Item item2 = new Item(1, "bottle of perfume", "", new BigDecimal("18.99"), "other", false);
		System.out.println(item2.getQuantity()+" "+item2.getName()+" at "+item2.getPrice());
		
		TaxComputer.evaluateApplicableTaxes(item2);
		TaxComputer.computeTax(item2);
		receipt.addItemToReceipt(item2);

		Item item3 = new Item(1, "packet of headache pills", "", new BigDecimal("9.75"), "medical product", false);
		System.out.println(item3.getQuantity()+" "+item3.getName()+" at "+item3.getPrice());
		
		TaxComputer.evaluateApplicableTaxes(item3);
		TaxComputer.computeTax(item3);
		receipt.addItemToReceipt(item3);

		Item item4 = new Item(1, "box of imported chocolates", "", new BigDecimal("11.25"), "food", true);
		System.out.println(item4.getQuantity()+" "+item4.getName()+" at "+item4.getPrice());
		
		TaxComputer.evaluateApplicableTaxes(item4);
		TaxComputer.computeTax(item4);
		receipt.addItemToReceipt(item4);

		receipt.calculateTotal();
		System.out.println();
		receipt.printReceipt();

		assertEquals(new BigDecimal("74.68"), receipt.getTotalPrice());
		assertEquals(new BigDecimal("6.70"), receipt.getSalesTaxes());

	}

}
