package com.cleeng.apiv3.domain;

import java.io.Serializable;

public class Items<X> implements Serializable {

	private static final long serialVersionUID = 1L;

	public int totalItemCount;
	public java.util.Vector<X> items;
}
