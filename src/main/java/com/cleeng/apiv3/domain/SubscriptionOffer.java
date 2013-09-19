package com.cleeng.apiv3.domain;

import java.io.Serializable;

public class SubscriptionOffer extends BaseOffer implements Serializable {

	private static final long serialVersionUID = 1L;

	public String period;
	public java.util.Vector<String> accessToTags;
}
