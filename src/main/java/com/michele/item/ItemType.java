package com.michele.item;

/**
 * Enumeration for the constants that represent the item types
 * @author michele
 *
 */
public enum ItemType {
	BOOK("book"),
	MED_PROD("medical product"),
	FOOD("food"),
	OTHER("other");
	
	 private final String type;

	
	    private ItemType(final String type) {
	        this.type = type;
	    }


	    @Override
	    public String toString() {
	        return type;
	    }
	
}


