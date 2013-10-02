package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class TransactionCriteria implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public String transactionId;
    public String offerId;
    public String publisherEmail;
    public String customerEmail;
    public String offerType;
    public Long dateFrom;
    public Long dateTo;
}
