package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true) // for "offers"
public class MultiCurrencyOfferId implements Serializable {

	private static final long serialVersionUID = 1L;

	public String multiCurrencyOfferId;
}
