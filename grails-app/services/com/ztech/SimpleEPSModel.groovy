package com.ztech

class SimpleEPSModel {

	@Override
	public double calculateIntrinsicValue(double pe, double eps, double EPSGrowthRate, 
										  double payOutRatio, double hurdleRate) {
		
			double projectedGrowthRate = (EPSGrowthRate > 0.15) ? 0.15 : 0.10
			double projectedPE = (pe > 20) ? 17 : 12
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
				
				
				
		
//		def result = cal.calculateIntrinsicValue(4.67, 0.33, 0.05, 0.30, 0.15)  // HMY
//		def result = cal.calculateIntrinsicValue(7.7, 5.46, 0.14, 0.35, 0.15)  // ESV
//		def result = cal.calculateIntrinsicValue(33.45, 1.28, 0.17, 0.00, 0.15)  // CER
		
		/*
		 *  Great Company to keep an eye on
		 */
//		def result = cal.calculateIntrinsicValue(16.66, 3.38, 0.14, 0.22, 0.15)  // DIS
//		def result = cal.calculateIntrinsicValue(17.06, 3.24, 0.17, 0.24, 0.15)  // HOG
//		def result = cal.calculateIntrinsicValue(14, 1.36, 0.08, 0.57, 0.15)  // GE
//		def result = cal.calculateIntrinsicValue(10.59, 0.9, 0.05, 0.17, 0.15)  // BAC
//		def result = cal.calculateIntrinsicValue(9.08, 4.35, 0.05, 0.29, 0.15)  // JPM

//		def result = cal.calculateIntrinsicValue(15.2, 4.48, 0.06, 0.57, 0.15)  // JNJ
//		def result = cal.calculateIntrinsicValue(17, 3.94, 0.08, 0.59, 0.15)  // PG
//		def result = cal.calculateIntrinsicValue(22, 36.75, 0.15, 0.00, 0.15)  // GOOG
//		def result = cal.calculateIntrinsicValue(18, 2.1, 0.14, 0.00, 0.15)  // EBAY
//		def result = cal.calculateIntrinsicValue(12.4, 7.66, 0.01, 0.31, 0.15)  // XOM
//		def result = cal.calculateIntrinsicValue(97.30, 0.22, 0.54, 0.00, 0.15)  // LNKD
//		def result = cal.calculateIntrinsicValue(8.89, 4.42, 0.10, 0.24, 0.15)  // C
		


		
		
		



		
		print result
	}

}
