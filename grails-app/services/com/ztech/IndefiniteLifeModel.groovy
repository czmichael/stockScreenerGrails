package com.ztech

class IndefiniteLifeModel {

	@Override
	public Double calculateIntrinsicValue(double eps, double growthRate1st, double growthRate2nd, 
		               double discountRate1st, double discountRate2nd, double longTermDebt, 
					   double sharesOutstanding) {

		Double growthToDiscountRatio1st = (1 + growthRate1st ) / (1 + discountRate1st);
        Double tenYearsEarningTotal = 
			StockUtil.calculateGeometricSequence(eps, growthToDiscountRatio1st, 10);
			
	    Double beyondTenYearsEarningTotal = 
			(eps * Math.pow((1 + growthRate1st), 11) / (discountRate2nd - growthRate2nd)) / 
															Math.pow((1 + discountRate1st), 10)
System.out.println(tenYearsEarningTotal)
println beyondTenYearsEarningTotal

		Double totalDiscountedFutureReturn = tenYearsEarningTotal + beyondTenYearsEarningTotal;
		Double netFutureReturn = totalDiscountedFutureReturn - longTermDebt;
		
		
//		Double perShareIntrinsicValue = netFutureReturn / sharesOutstanding;
println netFutureReturn
//println perShareIntrinsicValue		
		
//		return perShareIntrinsicValue;	
return null
			
	}

	@Override
	public Double calculateIntrinsicValue(Stock stock) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*
	 * Test main
	 */
	public static void main(String[] args) {
		IndefiniteLifeModel ilm = new IndefiniteLifeModel();
		
		ilm.calculateIntrinsicValue(10, 0.05, 0.05, 0.15, 0.15, 0, 0);  // CVX
	}

}
