package com.exchange.simple.stocks;


import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.exchange.simple.stocks.model.Stock;
import com.exchange.simple.stocks.model.StockType;
import com.exchange.simple.stocks.model.Trade;
import com.exchange.simple.stocks.model.TradeType;
import com.exchange.simple.stocks.service.StockService;
import com.exchange.simple.stocks.service.StockServiceImpl;


/**
 * main class
 * @author madhavi
 */
public class App 
{
	private static Log log = LogFactory.getLog(App.class);
	
	public static void main(String[] args)
    {
        try{
        StockService stockService = new StockServiceImpl();

        Stock tea = new Stock("TEA", StockType.COMMON, 0d, null, 100d, 110d);
        Stock pop = new Stock("POP", StockType.COMMON, 8d, null, 100d, 120d);
        Stock ale = new Stock("ALE", StockType.COMMON, 23d, null, 60d, 55d);
        Stock gin = new Stock("GIN", StockType.PREFERRED, 8d, 2d, 100d, 100d);
        Stock joe = new Stock("JOE", StockType.COMMON, 13d, null, 250d, 216.12d);
      
        List<Stock> stocks = new ArrayList<Stock>();
        stocks.add(tea);
        stocks.add(pop);
        stocks.add(ale);
        stocks.add(gin);
        stocks.add(joe);
      
        Stock tempStock = null;
        Trade trade = null;
        List<Trade> trades = null;
      
        Random rand = new Random();
        
        int nbTrades = rand.nextInt(100 - 10 + 1) + 10;
      
        Map<Stock, List<Trade>> map = new HashMap<Stock, List<Trade>>();
      
        for(int i = 0; i < nbTrades; i++) {
          
        	tempStock = stocks.get(rand.nextInt(stocks.size() - 1));
          
            trades = map.get(tempStock);
          
            if (trades == null) {
              
                trades = new ArrayList<Trade>();
              
                map.put(tempStock, trades);
            }
          
            trade = new Trade(tempStock, new Date(), (rand.nextInt()*1000 + 50), 
                                  rand.nextBoolean()?TradeType.BUY:TradeType.SELL, (rand.nextDouble()*1000d + 50d));
          
            trades.add(trade);
        }
      
        int minutesRange = 15;
        
        for(Stock stock: stocks) {
          
            trades = map.get(stock);
                
            System.out.println("Stock--->"+stock.getStockSymbol()+" Dividend Yield--->"+stockService.calculateDividendYield(stock)+
            		" P/ERatio-->"+stockService.calculatePERatio(stock)+" Stock Price--->"+stockService.calculateStockPrice(trades,minutesRange));
            
        }
         	System.out.println("Share Index--->"+stockService.calculateShareIndex(stocks));
        }catch(Exception ex){
        	log.error("Error in calculating stock details--->"+ex.getMessage());
        }
        
}
}
