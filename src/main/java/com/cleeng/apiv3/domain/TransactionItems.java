package com.cleeng.apiv3.domain;

import java.io.Serializable;

public class TransactionItems implements Serializable {

	private static final long serialVersionUID = 1L;

	public int totalItemCount;
	public java.util.Vector<Transaction> items;
        
	public int couponsUsed;
	public double publisherDiscount;
	public double distributorDiscount;
	public double totalEarnings;
	public double publisherEarnings;
	public double distributorEarnings;
	public double publisherTransactionPrice;
	public double distributorTransactionPrice;
	public String publisherCurrency;
	public String parentCurrency;
	public double couponsValue;
	public double totalRevenue;
}
