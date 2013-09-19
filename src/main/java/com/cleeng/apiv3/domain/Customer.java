package com.cleeng.apiv3.domain;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	public String id;
	public String displayName;
	public String firstName;
	public String lastName;
	public String currency;
	public String locale;
	public String country;
	public Boolean publisherAccess;
}
