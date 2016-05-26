#Sales Taxes Problem
This program is a java solution for the **Sales Taxes Problem** (https://github.com/xpeppers/sales-taxes-problem).
It takes in input a file, that contains items, and print a receipt that shows:
- a resume of purchased items;
- total price of items;
- total amount of applied taxes.


##Build and run
Clone the repository.
To build the program run in the main folder:

```
	mvn package
```

After the building, to run the program execute:

```
	java -cp target/salesTaxesProblem-0.0.1-SNAPSHOT.jar com.michele.salesTaxesProblem.SalesTaxesProblem <path-to-input-file>
```

An example is:

```
	java -cp target/salesTaxesProblem-0.0.1-SNAPSHOT.jar com.michele.salesTaxesProblem.SalesTaxesProblem input1.txt
```

The repository contains in the main folder:

- input1.txt
- input2.txt
- input3.txt

thar are the files that represent the inputs specified in the problem.

##Input format
Each line of the input file represents an item and is of the following format:


quantity**\t**name**\t**price**\t**type**\t**is_imported


where:
- quantity: the number of purchased istances of the specified item;
- name: the name of purchased item;
- price: price (without taxes) of the item;
- type: type of item (**book**, **medical product**, **food**, **other**);
- is_imported: **true** if the item is imported, **false** if the item is not imported.

##Unit tests
The code contains unit tests with the three input described in the text of problem. Unit tests are executed during the build, and print the receipts for the three input.

##Other info
- Java version: "1.8.0_91"
- OS: "Xubuntu 15.10"
