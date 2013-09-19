package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Criteria implements Serializable {

	private static final long serialVersionUID = 1L;

	public Boolean active;
	public String associateEmail;
}
