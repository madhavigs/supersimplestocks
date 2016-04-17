package com.exchange.simple.stocks.service;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

import com.exchange.simple.stocks.model.Stock;
import com.exchange.simple.stocks.model.StockType;
import com.exchange.simple.stocks.model.Trade;
import com.exchange.simple.stocks.model.TradeType;
import com.exchange.simple.stocks.service.StockService;
import com.exchange.simple.stocks.util.StockException;

import org.junit.Test;
import org.junit.Assert;

/**
 * Test class for stock calculation service impl
 * @author madhavi
 */
public class StockServiceImplTest {
  
    private StockService stockService = new StockServiceImpl();
    
    /**
  	 * Test calculation of dividend -common
  	 */
	 @Test
    public void testCalculateDividendYieldForCommon()
    {
		try{ 
		Stock stock = new Stock("TEA", StockType.COMMON, 0d, null, 100d, 110d);
        Assert.assertEquals(0.0d,
                    stockService.calculateDividendYield(stock), 0d);
		} catch(Exception ex){
			Assert.assertTrue(false);
		}
      		  
   }

   /**
  	 * Test method for calculation of dividend - Preferred
  	 */
	 @Test
    public void testCalculateDividendYieldForPreferred(){
		try{
		Stock stock = new Stock("GIN", StockType.PREFERRED, 8d, 2d, 100d, 100d);
        Assert.assertEquals(2.0d,
                    stockService.calculateDividendYield(stock), 0d);
		} catch(Exception ex){
			Assert.assertTrue(false);
		}
    }


  	/**
  	 * Test method for calculating PE Ratio
  	 */
	 @Test
    public void testCalculatePERatio()
    {
		try{
		Stock stock = new Stock("POP", StockType.COMMON, 8d, null, 100d, 120d);
        Assert.assertEquals(15.0,
                    stockService.calculatePERatio(stock), 0d);
		} catch(Exception ex){
			Assert.assertTrue(false);
		}
    }


    /**
     * Test calculate stock price
     */
    @Test
    public void testCalculateStockPrice() throws StockException {
      try{
        Stock tea = new Stock("TEA", StockType.COMMON, 0d, null, 100d, 110d);

        Trade trade1 = new Trade(tea, new Date(), 1000, TradeType.BUY, 110d);
        Trade trade2 = new Trade(tea, new Date(), 300, TradeType.SELL, 102d);
      
        List<Trade> trades = new ArrayList<Trade>();
        trades.add(trade1);
        trades.add(trade2);
      
        int minutesRange = 15;
		  Assert.assertEquals(108.15384615384616,
                           stockService.calculateStockPrice(trades,minutesRange), 0d);
      } catch(Exception ex){
			Assert.assertTrue(false);
      }
    }
  
    /**
     * Test calculation of shared index
     */
    @Test
    public void testCalculateShareIndex() {
        try{
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

		  Assert.assertEquals(109.4274593191908,
                           stockService.calculateShareIndex(stocks), 0d);
        } catch(Exception ex){
			Assert.assertTrue(false);
		}
    }
}
