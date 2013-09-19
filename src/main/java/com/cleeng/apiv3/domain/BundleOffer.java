package com.cleeng.apiv3.domain;

import java.io.Serializable;

public class BundleOffer extends BaseOffer implements Serializable {

	private static final long serialVersionUID = 1L;

	public int period;
	public Double averageRating;
	public java.util.Vector<String> offerIdList;
}
