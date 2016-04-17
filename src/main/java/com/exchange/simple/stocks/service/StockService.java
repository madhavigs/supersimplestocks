package com.exchange.simple.stocks.service;

import java.util.List;

import com.exchange.simple.stocks.util.StockException;
import com.exchange.simple.stocks.model.Stock;
import com.exchange.simple.stocks.model.Trade;

/**
 * stock service Interface
 * @author madhavi
 */
public interface StockService {
	
	/**
  	 * used to calculate dividend for given stock
  	 * @param tickerPrice
  	 * @param stock
  	 * @return
  	 */
	public double calculateDividendYield(Stock stock) throws Exception;
  
	/**
  	 * used to calculate P/E ratio for given stock
  	 * @param tickerPrice
  	 * @param lastDividend
  	 * @return
  	 */
	public double calculatePERatio(Stock stock) throws Exception;
	
    /**
     * Calculates stock price for a given list of trades.
     * @param list of trades
     * @throws StockException
     */
    double calculateStockPrice(List<Trade> trades, int minutesRange) throws Exception;

    /**
     * Calculates all share index for a given list of stocks.
     * @param stocks the list of stocks
     */
    double calculateShareIndex(List<Stock> stocks) throws Exception;  
}
