package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class RentalOfferData implements Serializable {

	private static final long serialVersionUID = 1L;

	public Double price; // required for create
	public String title; // required for create
	public Integer period; // required for create
	public String url; // required for create
	public String description;
	public Double socialCommissionRate;
	public String contentType;
	public String contentExternalId;
	public String contentExternalData;
	public Boolean contentAgeRestriction;
	public java.util.Vector<String> tags;
}
