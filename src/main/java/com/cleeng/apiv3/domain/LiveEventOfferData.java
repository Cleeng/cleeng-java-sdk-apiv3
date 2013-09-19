package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class LiveEventOfferData implements Serializable {

	private static final long serialVersionUID = 1L;

	public Double price; // required for create
	public String title; // required for create
	public String url; // required for create
	public String description;
	public Double socialCommissionRate;
	public String contentExternalId;
	public String contentExternalData;
	public Integer contentAgeRestriction;
	public Long startTime; // required for create
	public Long endTime; // required for create
	public Boolean remainerEmailActivated;
	public String remainderEmailBody;
	public String videoOnDemand;
	public Integer videoOnDemandRentalPeriod;
	public java.util.Vector<String> tags;
}
