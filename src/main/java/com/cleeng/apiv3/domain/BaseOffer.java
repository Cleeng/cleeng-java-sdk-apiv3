package com.cleeng.apiv3.domain;

import java.io.Serializable;

public abstract class BaseOffer {

	public String id;
	public String publisherEmail;
	public String url;
	public String title;
	public String description;
	public double price;
	public String applicableTaxRate;
	public String currency;
	public boolean active;
	public long createdAt;
	public long updatedAt;
}
