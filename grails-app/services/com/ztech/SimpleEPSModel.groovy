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
//		def result = cal.calculateIntrinsicValue(32, 1.36, 0.19, 0.38, 0.15)
//		def result = cal.calculateIntrinsicValue(12, 26.47, 0.05, 0.06, 0.15)  // CF
//		def result = cal.calculateIntrinsicValue(22.24, 0.77, 0.11, 0.39, 0.15)  // NVDA
//		def result = cal.calculateIntrinsicValue(4.67, 0.33, 0.99, 0.30, 0.15)  // HMY
//		def result = cal.calculateIntrinsicValue(7.7, 5.46, 0.14, 0.35, 0.15)  // ESV
//		def result = cal.calculateIntrinsicValue(23, 1.4, 0.08, 0.47, 0.15)  // GSH
//		def result = cal.calculateIntrinsicValue(33.45, 1.28, 0.17, 0.00, 0.15)  // CER
		
		// Great Company to keep an eye on
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
//		def result = cal.calculateIntrinsicValue(9.39, 8.64, 0.34, 0.01, 0.15)  // TM
//		def result = cal.calculateIntrinsicValue(10, 4, 0.10, 0.30, 0.15)  // WFC
		def result = cal.calculateIntrinsicValue(9.04, 15.2, 0.15, 0.25, 0.15)  // IBM
//		def result = cal.calculateIntrinsicValue(7.54, 2.62, 0.05, 0.21, 0.15)  // HPQ
		

		// My portfolio		
//		def result = cal.calculateIntrinsicValue(17, 4.11, 0.54, 0.12, 0.15)  // RBC
//		def result = cal.calculateIntrinsicValue(30, 0.76, 0.01, 0.60, 0.15)  // KNM
//		def result = cal.calculateIntrinsicValue(17, 2.15, 0.08, 0.39, 0.15)  // MANT
//		def result = cal.calculateIntrinsicValue(12.53, 5.45, 0.09, 0.14, 0.15)  // NOV
//		def result = cal.calculateIntrinsicValue(12.91, 4.40, 0.10, 0.34, 0.15)  // RS
//		def result = cal.calculateIntrinsicValue(13.93, 10.74, 0.13, 0.11, 0.15)  // VMI
//		def result = cal.calculateIntrinsicValue(12, 2.72, 0.10, 0.29, 0.15)  // FL
//		def result = cal.calculateIntrinsicValue(15.08, 2.58, 0.01, 0.29, 0.15)  // LUK
//		def result = cal.calculateIntrinsicValue(22.8, 0.7, 0.02, 2.12, 0.15)  // SUP
//		def result = cal.calculateIntrinsicValue(9.59, 5.66, 0.10, 0.05, 0.15)  // AGCO
//		def result = cal.calculateIntrinsicValue(8.14, 5.46, 0.13, 0.35, 0.15)  // ESV
//		def result = cal.calculateIntrinsicValue(12.76, 2.51, 0.03, 0.27, 0.15)  // CAJ
//		def result = cal.calculateIntrinsicValue(6.41, 1.89, 0.03, 0.12, 0.15)  // PBR
//		def result = cal.calculateIntrinsicValue(35.67, -1.25, -67.52, 0.50, 0.15)  // PAAS
//		def result = cal.calculateIntrinsicValue(10.3, 12.23, 0.05, 0.31, 0.15)  // CVX
		

		
		print result
	}

}
