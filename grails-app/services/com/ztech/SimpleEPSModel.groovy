package com.ztech

class SimpleEPSModel {

	@Override
	public double calculateIntrinsicValue(double pe, double eps, double EPSGrowthRate, 
										  double payOutRatio, double hurdleRate) {
		
			double projectedGrowthRate = (EPSGrowthRate >= 0.15) ? 0.15 : 0.10
			double projectedPE = (pe >= 20) ? 17 : 12
			double projectedEPS = eps * Math.pow((1 + projectedGrowthRate), 5.0)
			double stockPrcieFromEPS = projectedPE * projectedEPS
			
			double stockPriceFromDividend = 
				StockUtil.calculateGeometricSequence(eps, (1 + projectedGrowthRate), 5) * payOutRatio
			double totalFutureStockPrice = stockPrcieFromEPS + stockPriceFromDividend
			
			double result = totalFutureStockPrice / Math.pow((1 + hurdleRate), 5.0)
			
		return result;
	}

	@Override
	public double calculateIntrinsicValue(Stock stock) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		def cal = new SimpleEPSModel()

		
		/*
		 *  My portfolio
		 */
		
//		def result = cal.calculateIntrinsicValue(10.3, 11.23, 0.05, 0.31, 0.15)  // CVX
//		def result = cal.calculateIntrinsicValue(12, 14.86, 0.05, 0.36, 0.15) // IBM
//		def result = cal.calculateIntrinsicValue(12.8, 4, 0.05, 0.36, 0.15) // WFC
//		def result = cal.calculateIntrinsicValue(10, 11, 0.05, 0.36, 0.15) // TM
		def result = cal.calculateIntrinsicValue(10, 1.59, 0.05, 0.36, 0.15) // CSCO
				
		
		print result
	}

}
