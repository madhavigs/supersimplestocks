package com.exchange.simple.stocks.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.exchange.simple.stocks.model.Stock;
import com.exchange.simple.stocks.model.StockType;
import com.exchange.simple.stocks.model.Trade;
import com.exchange.simple.stocks.service.StockService;
import com.exchange.simple.stocks.util.StockUtil;

/**
 * stock service implementation for calculation
 * @author madhavi
 */
public class StockServiceImpl implements StockService {
  
	private static Log log = LogFactory.getLog(StockServiceImpl.class);
	
	private StockUtil stockUtil = new StockUtil();
	
	/**
  	 * used to calculate dividend for given stock
  	 * @param tickerPrice
  	 * @param stock
  	 * @return
  	 */
    
    public double calculateDividendYield(Stock stock) throws Exception{
    	double dividendValue = 0.0;
    	try{
	    	if(stock.getPrice() <= 0.0){
	    		return dividendValue;
	    	}
	    	if(stock.getStockType().equals(StockType.COMMON)){
	    		dividendValue = (stock.getLastDividend()) / stock.getPrice();
	    	}else{
	    		dividendValue = (double)Math.round((stock.getFixedDividend() * stock.getParValue()) / stock.getPrice());
	    	}
    	}catch(Exception ex){
    		log.error("Error in calculating dividend value--->"+ex.getMessage());
    		throw new Exception("Error in calculating dividend value--->", ex);
    	}
    	return dividendValue;
    }
    
    /**
  	 * used to calculate P/E ratio for given stock
  	 * @param tickerPrice
  	 * @param lastDividend
  	 * @return
  	 */
    
    public double calculatePERatio(Stock stock) throws Exception{
    	double peRatio = 0.0;
    	try{
	    	if(stock.getLastDividend() <= 0.0){
	    		return peRatio;
	    	}
    		peRatio =  stock.getPrice() / stock.getLastDividend();
    	}catch(Exception ex){
    		log.error("Error in calculating P/E Ratio--->"+ex.getMessage());
    		throw new Exception("Error in calculating P/E Ratio--->", ex);
    	}
    	return peRatio;
    }
	
    /**
     * used to calculate the stock Price
     * @param trades
     * @param minutesRange
     */
   @Override
    public double calculateStockPrice(List<Trade> trades, int minutesRange) throws Exception{
	   double stockPrice = 0.0;
	   try{
        if (trades == null) {
            return stockPrice;
        }
        List<Trade> filteredTrades = stockUtil.filterTradesbyTimeStamp(trades, minutesRange); //to filter trades based on timestamp
        if(filteredTrades!=null && filteredTrades.size()==0){
        	return stockPrice;
        }
        double[] tradesPrices = new double[filteredTrades.size()];
        double[] tradesQuantities = new double[filteredTrades.size()];
        int  i = 0;
        for(Trade trade : filteredTrades) {
            tradesPrices[i] = trade.getPrice();
            tradesQuantities[i] = trade.getQuantity();
            i++;
        }
        stockPrice =  stockUtil.calculateStockPrice(tradesPrices, tradesQuantities);
	   }catch(Exception ex){
		    log.error("Error in calculating Stock Price--->"+ex.getMessage());
   			throw new Exception("Error in calculating Stock Price--->", ex);
	   }
	   return stockPrice;
    }
   
   /**
    * used to calculate the share index
    * @param stocks
    */
    @Override
    public double calculateShareIndex(List<Stock> stocks) throws Exception{
    	double shareIndex = 0.0;
    	try{
    	double[] prices = new double[stocks.size()];
        int  i = 0;
        for(Stock stock : stocks) {
        	prices[i] = stock.getPrice();
        	i++;
        }
        shareIndex = stockUtil.calculateGeometricMean(prices);
    	}catch(Exception ex){
    		log.error("Error in calculating share index--->"+ex.getMessage());
   			throw new Exception("Error in calculating share index--->", ex);
    	}
    	return shareIndex;
    }
    
    
           
}