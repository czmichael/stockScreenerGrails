package com.ztech

import java.text.DecimalFormat;

import spock.lang.*

class StockUtilSpec extends Specification {
	
	def 'test calculateGeometricSequence'() {
		when:
		double sum = StockUtil.calculateGeometricSequence(1.36, 0.15, 5)
		DecimalFormat f = new DecimalFormat("##.00");
		def result = f.format(sum)
		
		then:
		'10.55' == result
	}

}
