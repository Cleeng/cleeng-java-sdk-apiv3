package com.cleeng.apiv3.domain;

import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class CustomerLibraryCriteria implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public Long dateFrom;
    public Long dateTo;
}
