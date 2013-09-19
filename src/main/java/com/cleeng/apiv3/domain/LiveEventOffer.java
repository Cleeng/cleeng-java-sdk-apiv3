package com.cleeng.apiv3.domain;

import java.io.Serializable;

public class LiveEventOffer extends BaseOffer implements Serializable {

	private static final long serialVersionUID = 1L;

	public String socialCommissionRate;
	public String contentExternalId;
	public String contentExternalData;
	public String contentAgeRestriction;
	public java.util.Vector<String> tags;
	public Double averageRating;
	public long startTime;
	public long endTime;
	public boolean eventReminderEmailActivated;
	public String eventReminderEmailBody;
	public boolean eventVideoOnDemand;
	public int eventVideoOnDemandRentalPeriod;
}
