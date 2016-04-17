package com.exchange.simple.stocks.util;

/**
 * Class used to throw @see StockCalculator exceptions.
 */
public class StockException extends Exception {

    static final long serialVersionUID = 123123123;

    /**
     * Default constructor.
     */
    public StockException() {}

  	 /**
  	  * Constructor with error message.
  	  * @param message the error message
  	  */
    public StockException(String message) {
        super(message);
    }
    
}
