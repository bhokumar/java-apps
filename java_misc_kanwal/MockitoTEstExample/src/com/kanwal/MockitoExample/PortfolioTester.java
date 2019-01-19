package com.kanwal.MockitoExample;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;


public class PortfolioTester {
Portfolio portfolio;
StockService stockService;

public static void main(String[] args) {
	PortfolioTester tester = new PortfolioTester();
	tester.setUp();
	System.out.println(tester.testMarketValue()? "pass":"fail");
	
}

public void setUp(){
	portfolio = new Portfolio();
	stockService = Mockito.mock(StockService.class);
	
	portfolio.setStockService(stockService);
	
	
}

public boolean testMarketValue(){
	List<Stock> stocks = new ArrayList<Stock>();
	Stock googleStock = new Stock("1", "Google",10);
	Stock microsoftStock = new Stock("2","Micorosoft",100);
	
	stocks.add(googleStock);
	stocks.add(microsoftStock);
	
	portfolio.setStocks(stocks);
	
	Mockito.when(stockService.getPrice(googleStock)).thenReturn(50.0);
	Mockito.when(stockService.getPrice(microsoftStock)).thenReturn(1000.0);
	
	double marketValue = portfolio.getMarketValue();
	return marketValue == 100500.0;
}

}
