package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CustomerLibrary implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public String transactionId;
    public Long transactionDate;
    public double transactionPrice;
    public String transactionCurrency;
    public String transactionExternalData;
    
    public String publisherName;
    public String publisherSiteUrl;
    
    public String offerId;
    public String offerType;
    public String offerTitle;        
    public String offerDescription;
    public String offerUrl;
    
    public double invoicePrice;
    public String invoiceCurrency;
    
    public int expiresAt;
    public Boolean cancelled;
}
