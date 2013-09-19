package com.cleeng.apiv3.domain;

import java.io.Serializable;

public class AccessStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean accessGranted;
	public String grantType;
	public Long expiresAt;
	public String socialCommissionUrl;
}
