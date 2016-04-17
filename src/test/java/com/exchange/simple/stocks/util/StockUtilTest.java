package com.exchange.simple.stocks.util;

import org.junit.Test;
import org.junit.Assert;

/**
 * Test class for stock utility.
 * @author madhavi
 */
public class StockUtilTest {
  	
  	private StockUtil stockUtil = new StockUtil();
  
  	
  	/**
  	 * Test method for Calculating Geometric mean
  	 */
	@Test
    public void testCalculateGeometricMean()
    {
	 try{
        Assert.assertEquals(0d,
                    stockUtil.calculateGeometricMean(), 0d);

        Assert.assertEquals(0d,
                    stockUtil.calculateGeometricMean(0d), 0d);

        Assert.assertEquals(23.321576831999096,
                    stockUtil.calculateGeometricMean(43d, 1.95d, 56d, 63d), 0d);
      
		  Assert.assertEquals(0d,
                    stockUtil.calculateGeometricMean(0d, 1.95d), 0d);
	 } catch(Exception ex){
		Assert.assertTrue(false);
	 }
    }

   /**
  	 * Test method for calculating stock Price
  	 */
	 @Test
    public void testCalculateStockPrice()
    {
		 try {
			Assert.assertEquals(10.227272727272727,
                    stockUtil.calculateStockPrice(
              	 new double[] {24d, 13d, 2.5d}, new double[] {4, 8, 10}), 0d);
        } catch (Exception ex) {
        	Assert.assertTrue(false);
        }
    }
}
