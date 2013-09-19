package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class AssociateData implements Serializable {

	private static final long serialVersionUID = 1L;

	public String email;
	public String locale;
	public String country;
	public String currency;
	public String firstName;
	public String lastName;
	public String siteName;
	public String publisherData;
}
