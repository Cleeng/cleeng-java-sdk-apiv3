package com.cleeng.apiv3.domain;

import java.io.Serializable;

public class SingleOffer extends BaseOffer implements Serializable {

	private static final long serialVersionUID = 1L;

	public String socialCommissionRate;
	public String contentType;
	public String contentExternalId;
	public String contentExternalData;
	public String contentAgeRestriction;
	public java.util.Vector<String> tags;
	public Double averageRating;
}
