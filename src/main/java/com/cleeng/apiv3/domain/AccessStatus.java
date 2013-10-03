package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AccessStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean accessGranted;
	public String grantType;
	public Long expiresAt;
	public String socialCommissionUrl;
	public boolean purchasedDirectly;
}
