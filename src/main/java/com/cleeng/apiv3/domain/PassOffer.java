package com.cleeng.apiv3.domain;

import java.io.Serializable;

public class PassOffer extends BaseOffer implements Serializable {

	private static final long serialVersionUID = 1L;

	public String period;
	public long expiresAt;
	public java.util.Vector<String> accessToTags;
}
