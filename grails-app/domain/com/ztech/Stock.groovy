package com.ztech

class Stock {
	String company;
	String symbol;
	Double price;
	Long marketCap;
	Double pricePerBook;
	Double pricePerEarning;
	Double yield;
	Double payOutRatio;
	Double currentAssetLiabilityRatio = 0.0;
	
    static constraints = {
		symbol(blank: false, unique: true)
    }
}
