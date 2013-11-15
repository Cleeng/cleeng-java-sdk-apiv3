package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CustomerLibraryItems implements Serializable {

	private static final long serialVersionUID = 1L;

	public int totalItemCount;
	public java.util.Vector<CustomerLibrary> items;
}
