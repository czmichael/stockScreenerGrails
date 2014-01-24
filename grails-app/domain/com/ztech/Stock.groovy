package com.ztech

class Stock {
	String company;
	String symbol;
	
	static belongsTo = [sector:Sector]
    static constraints = {
		symbol(blank: false, unique: true)
    }
}
