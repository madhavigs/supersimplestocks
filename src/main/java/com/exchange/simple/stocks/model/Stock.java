package com.exchange.simple.stocks.model;

import com.exchange.simple.stocks.model.StockType;

/**
 * Class representing a stock
 * @author madhavi
 */
public class Stock {

  	 /**
  	  * stockSymbol
  	  */
    private String stockSymbol;

    /** 
     * stockType 
     */
    private StockType stockType;
  
    /** 
     * stock lastDividend 
     */
    private Double lastDividend;
  
    /** 
     * stock fixedDividend 
     */
    private Double fixedDividend;
  
    /** 
     * stock parValue
     */
    private Double parValue;
  
    /**
     *  stock price 
     */
    private Double price;
  
    /**
     * Default constructor.
     */
    public Stock() {
      
    }
  
	 /**
	  * Constructor with all properties.
	  * @param stockSymbol
	  * @param stockType
	  * @param lastDividend
	  * @param fixedDividend
	  * @param parValue
	  * @param price
	  */
    public Stock(String stockSymbol,
                     StockType stockType,
                     Double lastDividend,
                     Double fixedDividend,
                     Double parValue,
                     Double price) {
      
        this.stockSymbol = stockSymbol;
        this.stockType = stockType;
        this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
        this.price = price;
    }
    	 
    /**
	 * @return the stockSymbol
	 */
	public String getStockSymbol() {
		return stockSymbol;
	}

	/**
	 * @param stockSymbol the stockSymbol to set
	 */
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	/**
	 * @return the stockType
	 */
	public StockType getStockType() {
		return stockType;
	}

	/**
	 * @param stockType the stockType to set
	 */
	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	/**
	 * @return the lastDividend
	 */
	public Double getLastDividend() {
		return lastDividend;
	}

	/**
	 * @param lastDividend the lastDividend to set
	 */
	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}

	/**
	 * @return the fixedDividend
	 */
	public Double getFixedDividend() {
		return fixedDividend;
	}

	/**
	 * @param fixedDividend the fixedDividend to set
	 */
	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	/**
	 * @return the parValue
	 */
	public Double getParValue() {
		return parValue;
	}

	/**
	 * @param parValue the parValue to set
	 */
	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fixedDividend == null) ? 0 : fixedDividend.hashCode());
		result = prime * result
				+ ((lastDividend == null) ? 0 : lastDividend.hashCode());
		result = prime * result
				+ ((parValue == null) ? 0 : parValue.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((stockSymbol == null) ? 0 : stockSymbol.hashCode());
		result = prime * result
				+ ((stockType == null) ? 0 : stockType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Stock other = (Stock) obj;
		if (fixedDividend == null) {
			if (other.fixedDividend != null) {
				return false;
			}
		} else if (!fixedDividend.equals(other.fixedDividend)) {
			return false;
		}
		if (lastDividend == null) {
			if (other.lastDividend != null) {
				return false;
			}
		} else if (!lastDividend.equals(other.lastDividend)) {
			return false;
		}
		if (parValue == null) {
			if (other.parValue != null) {
				return false;
			}
		} else if (!parValue.equals(other.parValue)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (stockSymbol == null) {
			if (other.stockSymbol != null) {
				return false;
			}
		} else if (!stockSymbol.equals(other.stockSymbol)) {
			return false;
		}
		if (stockType != other.stockType) {
			return false;
		}
		return true;
	}

	
}
