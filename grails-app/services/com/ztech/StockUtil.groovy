package com.ztech

class StockUtil {
	
	/**
	 * Calculate the sum of geometric sequence
	 * 
	 * @param firstTerm - starting term value
	 * @param commonRatio - the ratio between each term
	 * @param totalCount - total number of terms
	 * @return the sum of all the terms
	 */
	public static double calculateGeometricSequence(double firstTerm, double commonRatio, 
		int totalCount) {
			
		double sum = 0.0											
        for (int i = 0; i < totalCount; i++) {
			sum += firstTerm * Math.pow(commonRatio, (i + 1))	
		} 
		return sum;
		
	}

}
