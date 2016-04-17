package com.exchange.simple.stocks.util;

import java.util.ArrayList;
import java.util.List;

import com.exchange.simple.stocks.model.Trade;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * used for stock related calculation
 * @author madhavi
 */
public class StockUtil{
  	 	
	private static Log log = LogFactory.getLog(StockUtil.class);

   /**
    * used to calculate Geometric mean
    * @param prices
    * @return
    */
    
    public double calculateGeometricMean(double... prices) throws Exception {
    	double geometricMean = 0.0;
      try{
        if (prices == null || (prices != null && prices.length == 0)) {
            
            return geometricMean;
        }
      
         geometricMean = prices[0];
      
        for(int i = 1; i < prices.length; i++) {
          
            geometricMean *= prices[i];
        }
      
        Integer n = new Integer(prices.length);
      
        geometricMean =  Math.pow(geometricMean, 1.0d / n.doubleValue());
      }catch(Exception ex){
    	  log.error("Error in calculating Geometric Mean--->"+ex.getMessage());
  		  throw new Exception("Error in calculating Geometric Mean--->", ex);  
      }
      return geometricMean;
    }
  
    /**
     * @param tradesPrices
     * @param tradesQuantities
     * @return
     * @throws StockException
     */
    public double calculateStockPrice(double[] tradesPrices, double[] tradesQuantities) throws Exception {
    	double stockPrice = 0.0;
      try{
		double pricesPerQuantities = 0d;
        double quantities = 0d;
      
        for(int i = 0; i < tradesPrices.length; i++) {
          
            pricesPerQuantities += tradesPrices[i] * tradesQuantities[i];
          
            quantities += tradesQuantities[i];
        }
      
        stockPrice =  pricesPerQuantities / quantities;
      }catch(Exception ex){
    	  log.error("Error in calculating util Stock Price--->"+ex.getMessage());
  		  throw new Exception("Error in calculating Util Stock Price--->", ex); 
      }
      return stockPrice;
    }
    
    /**
     * to filter trades based on timestamp
     * @param trades
     * @param minuteRange
     * @return
     */
    public List<Trade> filterTradesbyTimeStamp(List<Trade> trades, int minuteRange){
	    Date now = new Date();	
	    List<Trade> tempTrades = new ArrayList<Trade>();
	    for(Trade trade:trades){
	    	if((trade.getTimestamp().getTime() -  now.getTime()) <= minuteRange * 60 * 1000){
	    		tempTrades.add(trade);
	    	}
	    }
	    return tempTrades;
    }
}
