package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Transaction implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public String transactionId;
    public String transactionExternalData;
    public String offerId;
    public String offerType;
    public String transactionType;
    public Long transactionDate;
    public String offerDescription;
    public String offerTitle;
    public String customerEmail;
    public String customerName;
    public int customerId;
    public String publisherEmail;
    public String siteName;
    public int publisherId;
    public double transactionPriceExclTax;
    public String transactionCurrency;
    public int receiptSent;
    public String url;
    public int cancellationDisabled;
}
