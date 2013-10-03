package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PassOffer extends BaseOffer implements Serializable {

	private static final long serialVersionUID = 1L;

	public String period;
	public long expiresAt;
	public java.util.Vector<String> accessToTags;
}
