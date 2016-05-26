package com.michele.salesTaxesProblem;

import com.michele.item.*;
import com.michele.receipt.*;
import com.michele.tax.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SalesTaxesProblem {

	public static void main(String[] args) {

		Receipt receipt = new Receipt();

		try {
			//reads all lines of the input file
			System.out.println("Reading input...");
			for (String line : Files.readAllLines(Paths.get(args[0]))) {
				//split each line
				String[] parts = line.split("\t");
				//create an item with informations obtained by splittd lines
				Item itemToIns = new Item(Integer.parseInt(parts[0]), parts[1], "", new BigDecimal(parts[2]), parts[3],
						Boolean.parseBoolean(parts[4]));
				System.out.println(itemToIns.getQuantity()+" "+itemToIns.getName()+" at "+itemToIns.getPrice());
				TaxComputer.evaluateApplicableTaxes(itemToIns);
				TaxComputer.computeTax(itemToIns);
				receipt.addItemToReceipt(itemToIns);

			}
		} catch (IOException e) {
			System.out.println("Bad file path!!");

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Bad input!!");
		}

		receipt.calculateTotal();
		System.out.println();
		receipt.printReceipt();

	}

}
